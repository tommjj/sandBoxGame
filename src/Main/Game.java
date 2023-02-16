package Main;

import entities.PointManager;
import java.awt.Graphics;

public class Game implements Runnable {

    private GamePanel gamePanel;
    private GameWindow gameWindow;
    private Thread gameThread;
    private final int FPS_SET = 120, UPS_SET = 280;

    private boolean updateCheck = false;

    private PointManager pointManager;
    
    private boolean mousePressedCheck = false;
    private int mX, mY;
    
    
    public Game() {
        initClasses();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);

        gamePanel.setFocusable(true);
        gamePanel.requestFocus();

        startGameLoop();
    }

    public PointManager getPointManager() {
        return pointManager;
    }

    public void setUpdateCheck(boolean updateCheck) {
        this.updateCheck = updateCheck;
    }

    public boolean isUpdateCheck() {
        return updateCheck;
    }

    private void initClasses() {
        pointManager = new PointManager();
    }

    public void update() {
        if(mousePressedCheck) {
            getPointManager().getSandsManager().createSand(mX, mY);
        }
        
        if (updateCheck) {
            pointManager.update();
        }
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void rander(Graphics g) {
        pointManager.draw(g);
    }
    
    

    @Override
    public void run() {
        double timePerFreme = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;
        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFreme;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    public void setMousePressedCheck(boolean mousePressedCheck) {
        this.mousePressedCheck = mousePressedCheck;
    }

    public void setmXY(int mX, int mY) {
        this.mX = mX;
        this.mY = mY;
    }
    
    
}
