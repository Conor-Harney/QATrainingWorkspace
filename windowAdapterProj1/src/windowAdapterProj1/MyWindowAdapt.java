package windowAdapterProj1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowAdapt extends WindowAdapter {

	public void windowOpened(WindowEvent e)
	{
		System.out.println("windowOpened");
	}
	public void windowClosing(WindowEvent e)
	{
		System.out.println("windowClosing");
	}
	public void windowClosed(WindowEvent e)
	{
		System.out.println("windowClosed");
	}
	public void windowIconified(WindowEvent e)
	{
		System.out.println("windowIconified");
	}
	public void windowDeiconified(WindowEvent e)
	{
		System.out.println("windowDeiconified");
	}
	public void windowActivated(WindowEvent e)
	{
		System.out.println("windowActivated");
	}
	public void windowDeactivated(WindowEvent e)
	{
		System.out.println("windowDeactivated");
	}
	
	
	

}
