package Main;

import Inputs.KeyInputs;
import Inputs.MouseInputs;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
    private Game game;
    private MouseInputs mouseInputs;
    private KeyInputs keyInputs;
    
    public GamePanel(Game game) {
        mouseInputs = new MouseInputs(this);
        keyInputs = new KeyInputs(this);
        this.game = game;
         
        this.addKeyListener(keyInputs);
        this.addMouseListener(mouseInputs);
        this.addMouseMotionListener(mouseInputs);
        setPanelSize();
        
    } 

    public Game getGame() {
        return game;
    }
    
    private void setPanelSize() {
        Dimension size = new Dimension(800, 500);
        setPreferredSize(size);       
    }
    
    @Override
    public  void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 500);
        game.rander(g);
    }
}
