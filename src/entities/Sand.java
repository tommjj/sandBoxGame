package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Sand {

    private int x, y;
    private SandsManager sandsManager;

    public Sand(int x, int y, SandsManager sandsManager) {
        this.sandsManager = sandsManager;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void update() {
        if (sandsManager.getPointManager().canMove(x, y + 1)) {
            y++;
        } else if (sandsManager.getPointManager().canMove(x - 1, y + 1) && sandsManager.getPointManager().canMove(x - 1, y)) {
            y++;
            x--;
        } else if (sandsManager.getPointManager().canMove(x + 1, y + 1) && sandsManager.getPointManager().canMove(x + 1, y)) {
            y++;
            x++;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(x, y, 1, 1);
    }
}
