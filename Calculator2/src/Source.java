import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Source {
	static Button[] m_buttons = new Button[15];
	static Dimension ELEMENT_SIZE = new Dimension(40,40);
	
	public static void addButton(String name, Panel pannelToAddTo, int arrayPos, String btnText)
	{
		m_buttons[arrayPos]= new Button(btnText);
		m_buttons[arrayPos].setName(name);
		m_buttons[arrayPos].setPreferredSize(ELEMENT_SIZE);
		pannelToAddTo.add(name, m_buttons[arrayPos]);
	}
	public static void main(String args[]) {
		
		Label m_resultLbl;
		MyListener m_eventListener;
		Frame m_frame = new Frame("Calculator");
		m_frame.setSize(800, 800);
		m_frame.setBackground(Color.RED);
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(4, 4));
		
	//set up buttons
		addButton("0Btn",   p2, 0,  "0");
		addButton("1Btn",   p2, 1,  "1");
		addButton("2Btn",   p2, 2,  "2");
		addButton("3Btn",   p2, 3,  "3");
		addButton("4Btn",   p2, 4,  "4");
		addButton("5Btn",   p2, 5,  "5");
		addButton("6Btn",   p2, 6,  "6");
		addButton("7Btn",   p2, 7,  "7");
		addButton("8Btn",   p2, 8,  "8");
		addButton("9Btn",   p2, 9,  "9");
		addButton("addBtn", p2, 10, "+");
		addButton("subBtn", p2, 11, "-");
		addButton("mltBtn", p2, 12, "*");
		addButton("divBtn", p2, 13, "/");
		addButton("eqlBtn", p2, 14, "=");
		
		m_resultLbl = new Label(" ");
		m_resultLbl.setPreferredSize(ELEMENT_SIZE);
		p1.add("output", m_resultLbl);
		
		m_eventListener = new MyListener(m_buttons, m_resultLbl);
		
		for(int i = 0; i < m_buttons.length; i++)
		{
			m_buttons[i].addActionListener(m_eventListener);
		}
		
		
	
		
	//set up labels 
		
		
		
		
		
	//setup the event listener
		/*m_eventListener = new MyListener(m_addBtn, m_subBtn, m_mltBtn, m_divBtn, m_param1TF, m_param2TF, m_resultTF);
		m_addBtn.addActionListener(m_eventListener);
		m_subBtn.addActionListener(m_eventListener);
		m_mltBtn.addActionListener(m_eventListener);
		m_divBtn.addActionListener(m_eventListener);*/
		
	//add the elements
		m_frame.add(p1, BorderLayout.NORTH);
		m_frame.add(p2, BorderLayout.CENTER);
		
		
		m_frame.setVisible(true);
		
		
		m_frame.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent we){
	        	m_frame.dispose();}
	    }
		);
		
		
	}
}
