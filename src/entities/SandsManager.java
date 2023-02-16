package entities;

import java.awt.Graphics;
import java.util.ArrayList;

public class SandsManager {

    private ArrayList<Sand> sands = new ArrayList<>();
    private PointManager pointManager;
    
    public SandsManager(PointManager pointManager) {
        this.pointManager = pointManager;
    }
    
    public ArrayList<Sand> getSands() {
        return sands;
    }
    
    public PointManager getPointManager() {
        return pointManager;
    }
    
    public void createSand(int x, int y) {
        if (pointManager.canMove(x, y)) {
            sands.add(new Sand(x, y, this));
        }
    }
    
    public void update() {
        int n = sands.size();
        for (int i = 0; i < n; i++) {
            sands.get(i).update();
        }
    }
    
    public void draw(Graphics g) {
        int n = sands.size();
        for (int i = 0; i < n; i++) {
            sands.get(i).draw(g);
        }
    }
}
