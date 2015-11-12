/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helicopter;

import javax.swing.*;
import java.awt.*;


/**
 *
 * @author nss5161
 */
public class Ship extends Rectangle {
    
    private int gravity;
    private int y;
    private int x;
    private final int WIDTH = 86;
    private final int HEIGHT = 57;
    
    public Ship(){
        x = 50;
        y = 400;
        
    }
    
    protected void paintComponent(Graphics g){
        g.drawRect(x, y, WIDTH, HEIGHT);
        g.fillRect(x, y, WIDTH, HEIGHT);
        
    }
}

