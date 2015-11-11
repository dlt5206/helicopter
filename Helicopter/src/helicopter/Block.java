/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helicopter;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author nss5161
 */
public class Block extends Rectangle {
    
    private int width = 100; 
    private int height = 100;
    private int x = 0; 
    private int y = 0;
    
    public Block(){
        
    }
    
    public void paint(Graphics g){
        g.drawRect(x, y, width, height);
        g.fillRect(x, y, width, height);
    }
}
