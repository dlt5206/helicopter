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
    
    private int gravity;
    private int y;
    private int x;
    private final int WIDTH = 86;
    private final int HEIGHT = 57;
    
    public Ship(){
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Image myImage = Toolkit.getDefaultToolkit().getImage("images/ship.png");
        g.drawImage(myImage, 0, 0, this);
    } 
}

