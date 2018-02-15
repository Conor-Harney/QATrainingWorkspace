import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Source {
	public static void main(String args[]) {
		Button m_addBtn, m_subBtn, m_mltBtn, m_divBtn;
		TextField m_param1TF, m_param2TF, m_resultTF;
		Label m_input1Lbl, m_input2Lbl, m_resultLbl;
		Dimension ELEMENT_SIZE = new Dimension(40,40);
		MyListener m_eventListener;
		Frame m_frame = new Frame("Calculator");
		m_frame.setSize(800, 800);
		m_frame.setBackground(Color.RED);
		FlowLayout myLayout = new FlowLayout();
		m_frame.setLayout(myLayout);
		
	//set up buttons
		m_addBtn = new Button("+");
		m_subBtn = new Button("-");
		m_mltBtn = new Button("X");
		m_divBtn = new Button("/");
		
		m_addBtn.setPreferredSize(ELEMENT_SIZE);
		m_subBtn.setPreferredSize(ELEMENT_SIZE);
		m_mltBtn.setPreferredSize(ELEMENT_SIZE);
		m_divBtn.setPreferredSize(ELEMENT_SIZE);
		
		//m_addBtn.set
		
	//set up text fields
		m_param1TF = new TextField();
		m_param2TF = new TextField();
		m_resultTF = new TextField();
		
		m_param1TF.setPreferredSize(ELEMENT_SIZE);
		m_param2TF.setPreferredSize(ELEMENT_SIZE);
		m_resultTF.setPreferredSize(ELEMENT_SIZE);
		
	//set up labels 
		m_input1Lbl = new Label("Number 1"); 
		m_input2Lbl = new Label("Number 2");
		m_resultLbl = new Label("Result");
		
		m_input1Lbl.setPreferredSize(ELEMENT_SIZE); 
		m_input2Lbl.setPreferredSize(ELEMENT_SIZE);
		m_resultLbl.setPreferredSize(ELEMENT_SIZE);
		
		
		
	//setup the event listener
		m_eventListener = new MyListener(m_addBtn, m_subBtn, m_mltBtn, m_divBtn, m_param1TF, m_param2TF, m_resultTF);
		m_addBtn.addActionListener(m_eventListener);
		m_subBtn.addActionListener(m_eventListener);
		m_mltBtn.addActionListener(m_eventListener);
		m_divBtn.addActionListener(m_eventListener);
		
	//add the elements
		m_frame.add(m_addBtn);
		m_frame.add(m_subBtn);
		m_frame.add(m_mltBtn);
		m_frame.add(m_divBtn);
		
		m_frame.add(m_input1Lbl);
		m_frame.add(m_param1TF);
		
		m_frame.add(m_input2Lbl);
		m_frame.add(m_param2TF);
		
		m_frame.add(m_resultLbl);
		m_frame.add(m_resultTF);
		
		
		m_frame.setVisible(true);
		
		
		m_frame.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent we){
	        	m_frame.dispose();}
	    }
		);
		
		
	}
}
