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
    private int height = 250;
    private int x = 750; 
    private int y = 200;
    
    public Block(){
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        
        
    }
}
