/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helicopter;

import javax.swing.*;

/**
 *
 * @author dlt5206
 */
public class Helicopter extends JFrame {
    
    private Home homePanel = new Home(); 
    private final static int FRAME_HEIGHT = 800;
    private final static int FRAME_WIDTH = 800;
    
    public Helicopter() {
        setLayout(null);
        add(homePanel);
        setSize(FRAME_HEIGHT, FRAME_WIDTH); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Helicopter heli = new Helicopter();
        heli.setVisible(true); 
    }
    
}
