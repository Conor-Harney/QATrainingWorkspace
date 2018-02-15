import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class CreateAccount {
	static Dimension FRAME_SIZE = new Dimension(400,400);
	static Dimension NAMING_ELEMENT_SIZE = new Dimension(FRAME_SIZE.width / 4,FRAME_SIZE.height / 5);
	static Dimension ELEMENT_SIZE = new Dimension((FRAME_SIZE.width - (NAMING_ELEMENT_SIZE.width * 2)) , NAMING_ELEMENT_SIZE.height);
	public static void initWindow()
	{
		
		JFrame m_frame = new JFrame("Create Account");
		initFrame(m_frame);
		m_frame.setLayout(new GridLayout(5,1));
		
		//labels
		Label nameLbl = new Label("Name:"), 
				adrLbl= new Label("Address:"), 
				genLbl= new Label("Gender:"), 
				accTypeLbl= new Label("Account type:");
		
		nameLbl.setPreferredSize(NAMING_ELEMENT_SIZE);
		adrLbl.setPreferredSize(NAMING_ELEMENT_SIZE);
		genLbl.setPreferredSize(NAMING_ELEMENT_SIZE);
		accTypeLbl.setPreferredSize(NAMING_ELEMENT_SIZE);
		

		//text fields
		TextField nameTF = new TextField("");
		nameTF.setPreferredSize(ELEMENT_SIZE);
		TextField adrTF = new TextField("");
		adrTF.setPreferredSize(ELEMENT_SIZE);
		
		//gender menu
		ArrayList<String> options = new ArrayList<String>();
		options.add("Male");
		options.add("Female");
		JMenu gdrMenu = InitDropDownSectionSection(genLbl.getText(), options);
		JMenuBar genMenuBar = new JMenuBar(); 
		genMenuBar.add(gdrMenu);
		
		//account type menu
		options = new ArrayList<String>();
		options.add("Current Account");
		options.add("Savings Account");
		JMenu accTypeMenu = InitDropDownSectionSection(accTypeLbl.getText(), options);
		JMenuBar accTypeMenuBar = new JMenuBar(); accTypeMenuBar.add(accTypeMenu);
		
		
		Button createBtn = new Button("Create account");
		createBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nameTF.getText().replaceAll("\\s+","") != "" && adrTF.getText().replaceAll("\\s+","") != "" 
						&&accTypeMenu.getText() != accTypeLbl.getText() && gdrMenu.getText() != genLbl.getText())
				{//default options are not selected
				if(JOptionPane.showConfirmDialog(
                        m_frame, 
                        "Welcome " + nameTF.getText() + "\nAccount number: " + 
                        MyConnector.createAccount(nameTF.getText(), adrTF.getText(), accTypeMenu.getText(), gdrMenu.getText()),
                        "Account Created",
                        JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION)
				{
					m_frame.dispose();
				}
				}
				else
				{
					JOptionPane.showMessageDialog(m_frame,"Invalid details detected.");
				}
			}
		});
		
		
		
		Panel namePanel = new Panel();
		namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		namePanel.add(nameLbl);
		namePanel.add(nameTF);
		m_frame.add(namePanel);
		
		Panel adrPanel = new Panel();
		adrPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		adrPanel.add(adrLbl);
		adrPanel.add(adrTF);
		m_frame.add(adrPanel);
		
		
		Panel gdrPanel = new Panel();
		gdrPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		gdrPanel.add(genLbl);
		gdrPanel.add(genMenuBar);
		m_frame.add(gdrPanel);
		
		Panel accPanel = new Panel();
		accPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		accPanel.add(accTypeLbl);
		accPanel.add(accTypeMenuBar);
		m_frame.add(accPanel);
		
		m_frame.add(createBtn);
		
		m_frame.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent we) 
	        {m_frame.dispose();}});
	}

	private static JMenu InitDropDownSectionSection(String menuTitle, ArrayList<String> options)
	{
		JMenu retMenu = new JMenu(menuTitle);
		for(int i = 0; i < options.size(); i++)
		{
			final String str = options.get(i);
			JMenuItem currentMItm = new JMenuItem(str);
			currentMItm.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					retMenu.setText(str);
				}
			});
			currentMItm.setSize(new Dimension(100,100));
			retMenu.add(currentMItm);
		}

		return retMenu;
	}

	private static void initFrame(Frame m_frame)
	{
		m_frame.setVisible(true);
		m_frame.setSize(FRAME_SIZE);
		m_frame.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				FRAME_SIZE.setSize(m_frame.getSize());
				NAMING_ELEMENT_SIZE.setSize(FRAME_SIZE.width / 4,FRAME_SIZE.height / 5);
				ELEMENT_SIZE.setSize((FRAME_SIZE.width - (NAMING_ELEMENT_SIZE.width * 2)) , NAMING_ELEMENT_SIZE.height);
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
