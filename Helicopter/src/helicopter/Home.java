/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helicopter;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author dlt5206
 */
public class Home extends JPanel {
    
    private JButton start = new JButton("Start");
    private Game gamePanel = new Game();
    private JLabel title = new JLabel("Helicopter Game");
    private final static int FRAME_HEIGHT = 800;
    private final static int FRAME_WIDTH = 800;
    
    
    public Home(Helicopter heli) {
        setLayout(null);
        setSize(FRAME_HEIGHT, FRAME_WIDTH);
        start.setBounds(683, 661, 100, 100); 
        title.setFont(new Font("Times", Font.BOLD, 36));
        title.setBounds(230, 150, 400, 200);
        add(title); 
        add(start);
        add(gamePanel);
        start.addActionListener( new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                startGame(heli);
            } 
        });
        setVisible(true);
    }
    
    public void startGame(Helicopter heli) {
        setVisible(false);
        heli.add(gamePanel);
        gamePanel.setVisible(true);
        repaint();
    }
}
