package radioCalculator;

import java.awt.Checkbox;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyItemListner implements ItemListener{
	TextField m_tf1, m_tf2;
	Label m_lbl1;
	
	public MyItemListner(TextField tf1, TextField tf2, Label lbl1) {
		m_tf1 = tf1;
		m_tf2 = tf2;
		m_lbl1 = lbl1;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Checkbox cb = (Checkbox)e.getSource();
		float i1 = Float.parseFloat(m_tf1.getText());
		float i2 = Float.parseFloat(m_tf2.getText());
		
		if(cb.getLabel().equals("+"))
		{
			m_lbl1.setText(Float.toString( i1 + i2 ));
		}
		else if(cb.getLabel().equals("-"))
		{
			m_lbl1.setText(Float.toString( i1 - i2 ));
		}
		else if(cb.getLabel().equals("*"))
		{
			m_lbl1.setText(Float.toString( i1 * i2 ));
		}
		else if(cb.getLabel().equals("/"))
		{
			m_lbl1.setText(Float.toString( i1 / i2 ));
		}
		
	}
	
}
