import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EventListener;

import javax.swing.ScrollPaneLayout;
import javax.swing.ViewportLayout;
import javax.swing.plaf.basic.DefaultMenuLayout;

public class Windows95_2 {
	
	public static void main(String args[])
	{
		Frame window = new Frame("Hello Nick");
		
		window.setLocation(150, 150);
		window.setBackground(Color.RED);
		window.setSize(800,800);
		window.setLayout(new  BorderLayout());
		TextField tf = new TextField("this is a line",2);
		
		window.add(tf);
		
		Button btn1 = new Button("Clickity claker 1");
		Button btn2 = new Button("Clickity claker 2");
		Button btn3 = new Button("Clickity claker 3");
		//Button btn4 = new Button("Clickity claker 4");
		//Button btn5 = new Button("Clickity claker 5");
		Dimension d = new Dimension(100, 100);
		
		ActionListener al = new MyActionListner(tf);
		
		btn1.setSize(d);
		btn1.setPreferredSize(d);
		window.add(btn1, BorderLayout.NORTH);
		btn1.setName("btn1");
		btn1.addActionListener(al);
		
		btn2.setSize(d);
		btn2.setPreferredSize(d);
		window.add(btn2, BorderLayout.EAST);
		btn2.setName("btn2");
		btn2.addActionListener(al);
		
		btn3.setSize(d);
		btn3.setPreferredSize(d);
		window.add(btn3, BorderLayout.SOUTH);
		btn3.setName("btn3");
		btn3.addActionListener(al);
		
		/*btn4.setSize(d);
		btn4.setPreferredSize(d);
		window.add(btn4, BorderLayout.WEST);
		btn4.setName("btn4");
		btn4.addActionListener(al);
		
		btn5.setSize(d);
		btn5.setPreferredSize(d);
		window.add(btn5);
		btn5.setName("btn5");
		btn5.addActionListener(al);*/
		

		window.setVisible(true);
		window.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent we) 
	        {window.dispose();}
	     }
	);
		
	}

}
