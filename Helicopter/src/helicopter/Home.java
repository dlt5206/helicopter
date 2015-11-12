/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helicopter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author dlt5206
 */
public class Home extends JPanel {
    
    private JButton start = new JButton("Start");
    private final static int FRAME_HEIGHT = 800;
    private final static int FRAME_WIDTH = 800;
    
    
    public Home() {
        setLayout(null);
        setSize(FRAME_HEIGHT, FRAME_WIDTH);
        start.setBounds(683, 661, 100, 100); 
        add(start);
        start.addActionListener( new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                startGame();
            } 
        });
        setVisible(true);
    }
    
    public void startGame() {
        setVisible(false);
    }
}
