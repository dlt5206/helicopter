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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 *
 * @author dlt5206
 */
public class Game extends JPanel implements ActionListener {
    
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
        t = new Timer(50, this);
        t.start();
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

        
        theShip = new Ship(x, y);
        add(theShip);
        theShip.setBounds(x, y, 86, 57);
        
        
        
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                y = y - 50;
                theShip.setY(y);
                if (theShip.getY() < 80) {
                    t.stop(); 
                    JOptionPane.showMessageDialog(null, "Game Over");
                }
                repaint();
            }
        });
        
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocusInWindow();
        g.setColor(Color.BLUE);
        
        g.fillRect(0, 0, 800, 100);
        g.fillRect(0, 660, 800, 100);
        
        blk = new Block();
        blk.paintComponent(g);
        
        

    }
    
    public void endGame() {
        System.exit(0); 
    }
    

    public void resetGame() {
        
    }
    
    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();
        if  (obj == theShip) {
            t.start();
        }
        if (obj == t) {
            y = y + 7;
            theShip.setY(y);
            if (theShip.getY() > 630) {
                t.stop(); 
                JOptionPane.showMessageDialog(null, "Game Over");
            }
            repaint();
        }
    }
  
}

