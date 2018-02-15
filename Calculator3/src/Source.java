import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.MouseInfo;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Source {
	static Button[] m_buttons = new Button[15];
	static Dimension ELEMENT_SIZE = new Dimension(40,40);
	
	public static void addButton(String name, Panel pannelToAddTo, int arrayPos, String btnText, String toolTipMsg,  Label toolTipLable)
	{
		m_buttons[arrayPos]= new Button(btnText);
		m_buttons[arrayPos].setName(name);
		m_buttons[arrayPos].setPreferredSize(ELEMENT_SIZE);
		m_buttons[arrayPos].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				toolTipLable.setText(toolTipMsg);
				
			}
		});
		pannelToAddTo.add(name, m_buttons[arrayPos]);
	}
	public static void main(String args[]) {
		
		Label m_resultLbl;
		MyListener m_eventListener;
		Frame m_frame = new Frame("Calculator");
		m_frame.setSize(800, 800);
		m_frame.setBackground(Color.RED);
		Panel screenPanel = new Panel();
		Panel buttonsPanel = new Panel();
		Panel helpPanel = new Panel();
		buttonsPanel.setLayout(new GridLayout(4, 4));
		helpPanel.setLayout(new FlowLayout());
		
	//helpPanel
		Label helpLabel = new Label("help");
		helpLabel.setPreferredSize(new Dimension(m_frame.getWidth() - 100, ELEMENT_SIZE.height));
		helpPanel.add("help", helpLabel);
		
	//buttons panel
		addButton("0Btn",   buttonsPanel, 0,  "0", "Add a zero to the number", helpLabel);
		addButton("1Btn",   buttonsPanel, 1,  "1", "Add a one to the number", helpLabel);
		addButton("2Btn",   buttonsPanel, 2,  "2", "Add a two to the number", helpLabel);
		addButton("3Btn",   buttonsPanel, 3,  "3", "Add a three to the number", helpLabel);
		addButton("4Btn",   buttonsPanel, 4,  "4", "Add a four to the number", helpLabel);
		addButton("5Btn",   buttonsPanel, 5,  "5", "Add a five to the number", helpLabel);
		addButton("6Btn",   buttonsPanel, 6,  "6", "Add a six to the number", helpLabel);
		addButton("7Btn",   buttonsPanel, 7,  "7", "Add a seven to the number", helpLabel);
		addButton("8Btn",   buttonsPanel, 8,  "8", "Add a eight to the number", helpLabel);
		addButton("9Btn",   buttonsPanel, 9,  "9", "Add a nine to the number", helpLabel);
		addButton("addBtn", buttonsPanel, 10, "+", "Add the current total to the next number", helpLabel);
		addButton("subBtn", buttonsPanel, 11, "-", "Subtract the next number from the current total", helpLabel);
		addButton("mltBtn", buttonsPanel, 12, "*", "Multiply the current total by the next number", helpLabel);
		addButton("divBtn", buttonsPanel, 13, "/", "Devide the current total by the next number", helpLabel);
		addButton("eqlBtn", buttonsPanel, 14, "=", "Output the total result of the calculations", helpLabel);
		
	//screen panel
		m_resultLbl = new Label(" ");
		m_resultLbl.setPreferredSize(ELEMENT_SIZE);
		screenPanel.add("output", m_resultLbl);
		
	
		
		
	//event listeners 
		m_eventListener = new MyListener(m_buttons, m_resultLbl);
		MouseMotionAdapter mml = new MouseMotionAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("I work... kinda");
				// TODO Auto-generated method stub
				Point pointDiffirence = new Point(MouseInfo.getPointerInfo().getLocation().x - m_buttons[0].getLocation().x, MouseInfo.getPointerInfo().getLocation().y - m_buttons[0].getLocation().y);
				if(pointDiffirence.x < 0) { pointDiffirence.x = (-pointDiffirence.x);}
				if(pointDiffirence.y < 0) { pointDiffirence.y = (-pointDiffirence.y);}
				if(pointDiffirence.x < (ELEMENT_SIZE.getWidth() / 2) &&  pointDiffirence.y < (ELEMENT_SIZE.getHeight() / 2)) {
					helpLabel.setText("I work!!!");
					System.out.println("I work... kinda");
				}
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		
		for(int i = 0; i < m_buttons.length; i++)
		{
			m_buttons[i].addActionListener(m_eventListener);
			
		}
		
		
	
		
	//set up labels 
		
		
		
		
		
	
		
	//add the elements
		m_frame.add(screenPanel, BorderLayout.NORTH);
		m_frame.add(buttonsPanel, BorderLayout.CENTER);
		m_frame.add(helpPanel, BorderLayout.SOUTH);
		
		
		m_frame.setVisible(true);
		
		
		m_frame.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent we){
	        	m_frame.dispose();}
	    }
		);
		
		
	}
}
