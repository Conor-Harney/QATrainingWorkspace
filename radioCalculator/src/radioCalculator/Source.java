package radioCalculator;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Source {
	

	public static void main(String Args[])
	{
		CheckboxGroup cbg = new CheckboxGroup();
		Checkbox cbAdd = new Checkbox("+", false);
		Checkbox cbSub = new Checkbox("-", false);
		Checkbox cbMul = new Checkbox("*", false);
		Checkbox cbDiv = new Checkbox("/", false);
		cbAdd.setCheckboxGroup(cbg);
		cbSub.setCheckboxGroup(cbg);
		cbMul.setCheckboxGroup(cbg);
		cbDiv.setCheckboxGroup(cbg);
		
		TextField tf1, tf2;
		tf1 = new TextField("");
		tf2 = new TextField("");
		
		Label lbl1 = new Label("answer");
		Label name1 = new Label("First");
		Label name2 = new Label("Second");
		
		MyItemListner mil = new MyItemListner(tf1, tf2, lbl1);
		cbAdd.addItemListener(mil);
		cbSub.addItemListener(mil);
		cbMul.addItemListener(mil);
		cbDiv.addItemListener(mil);
		
		Frame m_frame = new Frame("Calculator");
		m_frame.setBackground(Color.RED);
		m_frame.setSize(800, 800);
		Panel p1 = new Panel(new GridLayout(7, 2));
		
		p1.add(name1);
		p1.add(tf1);
		p1.add(name2);
		p1.add(tf2);
		p1.add(cbAdd);
		p1.add(new Label(""));
		p1.add(cbSub);
		p1.add(new Label(""));
		p1.add(cbMul);
		p1.add(new Label(""));
		p1.add(cbDiv);
		p1.add(new Label(""));
		p1.add(lbl1);
		p1.add(new Label(""));
		
		m_frame.add(p1, BorderLayout.CENTER);
		m_frame.setVisible(true);
		
		m_frame.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent we){
	        	m_frame.dispose();}
	    }
		);
		
		
	}

}
