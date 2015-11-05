/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helicopter;

import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author nss5161
 */
public class Block extends JComponent{
    
    int block_width = 100;
    int block_height = 300;
    
    int x = 0;
    int y = 0;
    
    public Block(){

    }
    
    public void paint(Graphics g){
        g.drawRect(x, y, block_width, block_height);
        g.fillRect(x, y, block_width, block_height);
    }
}
