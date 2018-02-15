import java.awt.Button;
import java.awt.TextField;
import java.awt.event.*;


public class MyActionListner implements ActionListener {
	private TextField m_tF;
	public MyActionListner()
	{
		m_tF = new TextField();
	}
	public MyActionListner(TextField tf)
	{
		m_tF = tf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button b = (Button) e.getSource();
		m_tF.setText("hello world from " + b.getName());
	}
	
	public void actionPerformed(ActionEvent e, int btnNumber) {
		System.out.println("hello world from button " + btnNumber);
	}
	
}
