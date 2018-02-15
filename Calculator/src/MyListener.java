import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.spi.DirStateFactory.Result;

public class MyListener implements ActionListener {
		Button m_addBtn, m_subBtn, m_mltBtn, m_divBtn;
		TextField m_param1TF, m_param2TF, m_resultTF;
	public MyListener(Button addBtn, Button subBtn, Button mltBtn, Button divBtn, TextField param1TF, TextField param2TF, TextField resultTF)
	{
		m_addBtn = addBtn;
		m_subBtn = subBtn;
		m_mltBtn = mltBtn;
		m_divBtn = divBtn;
		
		m_param1TF = param1TF; 
		m_param2TF = param2TF;
		m_resultTF = resultTF;
	}
	@Override
	public void actionPerformed(ActionEvent event)
	{
		int num1 = 0, num2 = 0, result = 0;
		try {
			num1 = Integer.parseInt(m_param1TF.getText());
			num2 = Integer.parseInt(m_param2TF.getText());
			result = 0;
		
			Button eventBtn = (Button)event.getSource();
			
			
			if(eventBtn.equals(m_addBtn))
			{
				result = num1 + num2;
			}
			else if(eventBtn.equals(m_subBtn))
			{
				result = num1 - num2;
			}
			else if(eventBtn.equals(m_mltBtn))
			{
				result = num1 * num2;
			}
			else if(eventBtn.equals(m_divBtn))
			{
				if(num2 == 0)
					m_resultTF.setText("Can't devide by 0");
				else if( num2 > num1)
					m_resultTF.setText("Can't devide by 0");
				else
					result = num1 / num2;
			}
			else
			{
				//unknown button!
			}
			String resultStr = Integer.toString(result);
			m_resultTF.setText(resultStr);
		}
		catch(ArithmeticException e)
		{
			m_resultTF.setText("ArithmeticException");
		}
		catch(StringIndexOutOfBoundsException e)
		{
			m_resultTF.setText("ArithmeticException");
		}
		catch(NumberFormatException e)
		{
			//the parse has failed 
			m_resultTF.setText("ArithmeticException");
			
		}
		
	}
}
