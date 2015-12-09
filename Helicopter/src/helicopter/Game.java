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
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
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
    private int score = 0;
    private JLabel scoreLabel = new JLabel();
    
    public Game() {
        t = new Timer(45, this);
        setLayout(null);
        setSize(FRAME_HEIGHT, FRAME_WIDTH);
        endButton.setBounds(683, 660, 100, 100);
        resetButton.setBounds(533, 660, 150, 100);
        scoreLabel.setBounds(10, 650, 200, 100);
        scoreLabel.setText("Score: " + Integer.toString(score));
        scoreLabel.setFont(new Font("Times", Font.BOLD, 20));
        scoreLabel.setForeground(Color.WHITE);
        add(endButton);
        add(resetButton);
        add(scoreLabel);
        
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
        
        this.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    t.stop();
                    JOptionPane.showMessageDialog(null, "Game is paused");
                }
            }
            public void keyReleased(KeyEvent e) {
                
            }
            public void keyTyped(KeyEvent e) {
                
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
        score = 0;
        scoreLabel.setBounds(10, 650, 200, 100);
        scoreLabel.setText("Score: " + Integer.toString(score));
        scoreLabel.setFont(new Font("Times", Font.BOLD, 20));
        scoreLabel.setForeground(Color.WHITE);
        add(theBlock);
        add(scoreLabel);
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
        if (obj == t) {
            y = y + 12;
            theShip.setY(y);
            if (theShip.getY() > 640) {
                t.stop(); 
                JOptionPane.showMessageDialog(null, "Game Over");
            }
            theBlock.setX(theBlock.getX() - 10);
            if (theBlock.getX() < 0) {
                remove(theBlock);
                theBlock = new Block();
                add(theBlock);
                score++; 
                scoreLabel.setText("Score: " + Integer.toString(score));
            }
            Rectangle shipBounds = new Rectangle(theShip.getX(), theShip.getY(), theShip.getWidth(), theShip.getHeight());
            Rectangle blockBounds = new Rectangle(theBlock.getX(), theBlock.getY(), theBlock.getWidth(), theBlock.getHeight());
            if (shipBounds.intersects(blockBounds)) {
                t.stop(); 
                JOptionPane.showMessageDialog(null, "Game Over");
            }
            repaint();
        }
    }
}

