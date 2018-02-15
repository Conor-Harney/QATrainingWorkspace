import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.spi.DirStateFactory.Result;

public class MyListener implements ActionListener {
	Button[] m_buttons;
	Label m_resultLbl;
	float total;
	String previousOperator = "=";
	boolean resetField = false;

	public MyListener(Button[] buttons, Label resultLbl) {
		total = 0;
		m_buttons = buttons;
		m_resultLbl = resultLbl;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		for (int i = 0; i < m_buttons.length; i++) {

			if (event.getSource() == m_buttons[i]) {
				String currentLblTxt = m_resultLbl.getText();// what's Currently in the label
				String curBtnTxt = m_buttons[i].getLabel();// what's on the current button

				if (resetField && previousOperator.equals("=")) {
					resetField = false;
					currentLblTxt = "";
					m_resultLbl.setText("");
					total = 0;
				}
				boolean foundChar = false;
				try {
					for (int o = 0; o <= 9; o++) {// check for num buttons
						if (curBtnTxt.equals(Integer.toString(i))) {
							currentLblTxt += curBtnTxt;
							m_resultLbl.setText(currentLblTxt);
							foundChar = true;
							break;
						}
					}
					if (!foundChar) {// check the operators
						if (curBtnTxt.equals("+") || curBtnTxt.equals("-") || curBtnTxt.equals("*")
								|| curBtnTxt.equals("/") || curBtnTxt.equals("=")) {// Operator
							foundChar = true;
							Float currentVal1 = Float.parseFloat(currentLblTxt);
							switch (previousOperator) {
							case "+":
								total += currentVal1;
								break;
							case "=":
								total += currentVal1;
								break;
							case "-":
								total -= currentVal1;
								break;
							case "*":
								total *= currentVal1;
								break;
							case "/":
								total /= currentVal1;
								break;
							}
							previousOperator = curBtnTxt;
							currentLblTxt = "";
							if (curBtnTxt.equals("=")) {
								m_resultLbl.setText(Float.toString(total));
								total = 0;
								resetField = true;
							} else {
								m_resultLbl.setText("");
							}
							break;
						}
					}
					break;
				} catch (ArithmeticException e) {
					// m_resultTF.setText("ArithmeticException");
				} catch (StringIndexOutOfBoundsException e) {
					// m_resultTF.setText("ArithmeticException");
				}catch (Exception e) {
					
				}
			}

		}
	}
}
