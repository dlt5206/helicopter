import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class myJPanel1 extends JPanel
{
	public myJPanel1()
	{
	}
//=====================================
	public void paintComponent(Graphics g) 
	{
    	super.paintComponent(g); 
    	Image myImage = Toolkit.getDefaultToolkit().getImage("images/r10.jpg");
    	g.drawImage(myImage, 0, 0, this);    	
        g.fillRect(100,20,70,80);
        g.setColor(Color.yellow);
        g.drawString("text on a Panel", 100,150);

    }
}
