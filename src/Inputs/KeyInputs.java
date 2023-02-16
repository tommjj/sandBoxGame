package Inputs;

import Main.GamePanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputs implements KeyListener{
    private GamePanel gamePanel;

    public KeyInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        gamePanel.getGame().setUpdateCheck(!gamePanel.getGame().isUpdateCheck());
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
}
