import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class myJFrame4 extends JFrame
{
	myJPanel1 mjp1;
	public myJFrame4 ()
	{
		super ("My First Frame");
//------------------------------------------------------
// Create components: Jpanel, JLabel and JTextField
    	mjp1 = new myJPanel1();
//------------------------------------------------------
// Choose a Layout for JFrame and 
// add Jpanel to JFrame according to layout    	
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(mjp1,"Center");
//------------------------------------------------------
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (1050, 1000);
		setVisible(true);
	}
//-------------------------------------------------------------------
}
