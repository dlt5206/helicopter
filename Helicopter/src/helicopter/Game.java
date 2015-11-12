/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helicopter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;


/**
 *
 * @author dlt5206
 */
public class Game extends JPanel {
    
    private int x = 100;
    private int y = 350;
    private Ship theShip;
    private Block theBlock;
    private Timer t;
    private JButton resetButton = new JButton("Reset Game");
    private JButton endButton = new JButton("End Game");
    private final static int FRAME_HEIGHT = 800;
    private final static int FRAME_WIDTH = 800;
    private Block blk;
    
    public Game() {
        setLayout(null);
        setSize(FRAME_HEIGHT, FRAME_WIDTH);
        endButton.setBounds(683, 660, 100, 100);
        resetButton.setBounds(533, 660, 150, 100);
        add(endButton);
        add(resetButton);
        
        endButton.addActionListener( new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                endGame();
            } 
        });
        
        resetButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        setVisible(false);

        
        theShip = new Ship();
        add(theShip);
        

    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        
        g.fillRect(0, 0, 800, 100);
        g.fillRect(0, 660, 800, 100);
        
        blk = new Block();
        blk.paintComponent(g);
        
        theShip.setBounds(x, y, 86, 57);

    }
    
    public void endGame() {
        System.exit(0); 
    }
    

    public void resetGame() {
        
    }
}

