package entities;

import java.awt.Graphics;
import java.util.ArrayList;

public class SandsManager {
    private ArrayList<Sand> sands = new ArrayList<>();

    public SandsManager() {
    }
    
    public boolean canMove(int x, int y) {
        if(x < 1 || x > 799)
            return false;
        if(y < 1 || y > 499)
            return false;
        int n = sands.size();
        for (int i = 0; i < n; i++) {
            if(sands.get(i).getX() == x && sands.get(i).getY() == y) {
                return false;
            }
        }
        return true;
    }
    
    public void createSand(int x, int y) {
        sands.add(new Sand(x, y, this));
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
