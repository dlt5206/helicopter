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
import java.awt.geom.Area;


/**
 *
 * @author dlt5206
 */
public class Game extends JPanel implements ActionListener {
    
    private int x = 100;
    private int y = 300;
    private Ship theShip;
    private Block theBlock;
    private Timer t;
    private JButton resetButton = new JButton("Reset Game");
    private JButton endButton = new JButton("End Game");
    private final static int FRAME_HEIGHT = 800;
    private final static int FRAME_WIDTH = 800;
    
    public Game() {
        t = new Timer(45, this);
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
        
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                t.start();
                y = y - 70;
                theShip.setY(y);
                if (theShip.getY() < 60) {
                    t.stop(); 
                    JOptionPane.showMessageDialog(null, "Game Over");
                }
                repaint();
            }
        });
        
        theShip = new Ship(x, y);
        add(theShip);
        theShip.setBounds(x, y, 86, 57);
        
        theBlock = new Block();
        add(theBlock);
        
        setVisible(false);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocusInWindow();
        g.setColor(Color.BLUE); 
        g.fillRect(0, 0, 800, 100);
        g.fillRect(0, 660, 800, 100);  
    }
    
    public void endGame() {
        System.exit(0); 
    }
    

    public void resetGame() {
        removeAll();
        x = 100;
        y = 300;
        theShip = new Ship(x, y);
        add(theShip);
        theShip.setBounds(x, y, 86, 57);
        theBlock = new Block();
        add(theBlock);
        t.start();
        endButton.setBounds(683, 660, 100, 100);
        resetButton.setBounds(533, 660, 150, 100);
        add(endButton);
        add(resetButton);
        revalidate();
        repaint();
    }
    
    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();
        if  (obj == theShip) {
            t.start();
        }
        if (obj == t) {
            y = y + 12;
            theShip.setY(y);
            if (theShip.getY() > 640) {
                t.stop(); 
                JOptionPane.showMessageDialog(null, "Game Over");
            }
            theBlock.setX(theBlock.getX() - 5);
            if (theBlock.getX() < 0) {
                remove(theBlock);
                theBlock = new Block();
                add(theBlock);
            }
            /*if (((theShip.getX() + 80) >= theBlock.getX()) && (theShip.getX() + 80) <= (theBlock.getX() + 50)) {
                if ((theShip.getY() >= theBlock.getY()) && (theShip.getY() <= (theBlock.getY() + 220))) {
                    t.stop(); 
                    JOptionPane.showMessageDialog(null, "Game Over");
                }
            }
            if (((theShip.getX() + 80) >= theBlock.getX()) && (theShip.getX() + 80) <= (theBlock.getX() + 40)) {
                if ((theShip.getY() + 40 >= theBlock.getY()) && (theShip.getY() + 40 <= (theBlock.getY() + 220))) {
                    t.stop(); 
                    JOptionPane.showMessageDialog(null, "Game Over");
                }
            }*/
            /*Rectangle block = theBlock.getBounds();
            Rectangle result = SwingUtilities.computeIntersection(theShip.getX(), theShip.getY(), theShip.getWidth(), theShip.getHeight(), block);
            if ((result.getHeight() > 0) && (result.getWidth() > 0)) {
                t.stop(); 
                JOptionPane.showMessageDialog(null, "Game Over");
            }*/
            Area ship = new Area(theBlock.getBounds());
            Area block = new Area(theBlock.getBounds());
            if (ship.contains(block.getBounds2D())) {
                t.stop(); 
                JOptionPane.showMessageDialog(null, "Game Over");
            }
            repaint();
        }
    }
}

