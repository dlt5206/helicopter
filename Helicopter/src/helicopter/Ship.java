/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helicopter;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author nss5161
 */
public class Ship extends JComponent {
    
    private int gravity = 20;
    private int y;
    private int x;
    private final int WIDTH = 86;
    private final int HEIGHT = 57;
    
    public Ship(int initX, int initY){
        x = initX;
        y = initY;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Image myImage = Toolkit.getDefaultToolkit().getImage("images/ship.png");
        g.drawImage(myImage, 0, 0, this);
       
    } 
    
    public void setX(int initX) {
        x = initX;
    }
    
    public int getX() {
        return x;
    }
    
    public void setY(int initY) {
        y = initY;
    }
    
    public int getY() {
        return y;
    }
    
    public int getGravity() {
        return gravity;
    }
}

