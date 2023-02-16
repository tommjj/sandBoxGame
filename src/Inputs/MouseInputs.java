package Inputs;

import Main.GamePanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {

    private GamePanel gamepanel;

    public MouseInputs(GamePanel gamepanel) {
        this.gamepanel = gamepanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //gamepanel.getGame().getSandsManager().createSand(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        gamepanel.getGame().setmXY(e.getX(), e.getY());
        gamepanel.getGame().setMousePressedCheck(true);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        gamepanel.getGame().setMousePressedCheck(false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        gamepanel.getGame().setmXY(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
