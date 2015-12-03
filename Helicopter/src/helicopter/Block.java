/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helicopter;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.util.*;


/**
 *
 * @author nss5161
 */
public class Block extends JComponent {
    
    private int width = 50; 
    private int height = 220;
    private int x;
    private int y;
    
    public Block(){
        Random rnd = new Random();
        x = 750;
        y = rnd.nextInt(200) + 200;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Image myImage = Toolkit.getDefaultToolkit().getImage("images/wall.png");
        g.drawImage(myImage, 0, 0, this);
       
    } 
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
