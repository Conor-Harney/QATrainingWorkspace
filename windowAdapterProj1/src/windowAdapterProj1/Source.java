package windowAdapterProj1;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Source {
	public static void main(String args[]) {
		MyWindowAdapt wa = new MyWindowAdapt();
		Frame m_frame = new Frame("title");
		m_frame.setSize(800, 800);
		m_frame.addWindowListener(wa);
		m_frame.setVisible(true);
		
		Random r = new Random();
		int i = r.nextInt(900);
		
		System.out.println(i);
		
		
		
		int min = 0;
		int max = 255;
		m_frame.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent we){
	        	m_frame.setSize(r.nextInt(900), r.nextInt(900));
	        	Color myColor = new Color((r.nextInt(max + 1 - min) + min), (r.nextInt(max + 1 - min) + min), (r.nextInt(max + 1 - min) + min));
	        	m_frame.setBackground(myColor);
	        	/*m_frame.dispose();*/}
	    }
		);
	}
}
