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
        endButton.setBounds(683, 658, 100, 100);
        add(endButton);
        endButton.addActionListener( new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                endGame();
            } 
        });
        setVisible(false);
        
        theShip = new Ship();
        add(theShip);
        
    }
    
    public void endGame() {
        System.exit(0); 
    }
    
    public void paintComponent(Graphics g){
        blk = new Block();
        blk.paintComponent(g);
        
        theShip.setBounds(x, y, 86, 57);
    }
    
}
