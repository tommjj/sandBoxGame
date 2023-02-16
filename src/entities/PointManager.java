package entities;

import java.awt.Graphics;

public class PointManager {
    private int point[][] = new int[801][501];
    private SandsManager sandsManager;
    
    public PointManager() {
        initClasses();
    }
    
    private void initClasses() {
        sandsManager = new SandsManager(this);
    }
    
    public void resetPoint() {
        for(int i = 0;i <  801; i++)
            for(int j = 0;j <  501; j++)
                point[i][j] = 0;
    }
    
    public void setPoint() {
        resetPoint();
        int n = sandsManager.getSands().size();
        for (int i = 0; i < n; i++) {
            point[sandsManager.getSands().get(i).getX()][sandsManager.getSands().get(i).getY()] = 1;
        }
    }
    
    public void update() {
        setPoint();
        sandsManager.update();
    }
    
    public void draw(Graphics g) {
        sandsManager.draw(g);
    }
    
    public boolean canMove(int x, int y) {
        if(x < 1 || x > 799)
            return false;
        if(y < 1 || y > 499)
            return false;
        return point[x][y] == 0;
    }

    public SandsManager getSandsManager() {
        return sandsManager;
    }
    
    
}
