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
import java.lang.Character.Subset;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DisplayAccount {
	static final int NUM_OF_ROWS = 6;
	static Dimension FRAME_SIZE = new Dimension(400, 400);
	static Dimension ELEMENT_SIZE = new Dimension((FRAME_SIZE.width / 3)
			- (FRAME_SIZE.width / 10), FRAME_SIZE.height / NUM_OF_ROWS);
	static final int NUM_OF_OPUTS = 5;
	static Label[] outputs = new Label[NUM_OF_OPUTS];
	static Label[] outputNames = new Label[NUM_OF_OPUTS];
	static Panel[] panels = new Panel[NUM_OF_ROWS];

	public static void initViewer() {
		ELEMENT_SIZE = new Dimension(50, 50);
		Frame m_frame = new Frame("View Account");
		initFrame(m_frame);
		m_frame.setLayout(new GridLayout(NUM_OF_ROWS, 1));

		for (int i = 0; i < NUM_OF_OPUTS; i++) {
			outputs[i] = new Label("          ");
			outputs[i].setVisible(true);
			outputs[i].setPreferredSize(ELEMENT_SIZE);
			outputNames[i] = new Label("          ");
			outputNames[i].setVisible(true);
			outputNames[i].setPreferredSize(ELEMENT_SIZE);
		}

		int oPutCounter = 0;
		// name panel
		panels[oPutCounter + 1] = new Panel(new GridLayout(1, 4));
		outputNames[oPutCounter].setText("Name:");
		panels[oPutCounter + 1].add(outputNames[oPutCounter]);
		panels[oPutCounter + 1].add(outputs[oPutCounter]);
		panels[oPutCounter + 1].add(new Label());
		panels[oPutCounter + 1].add(new Label());
		oPutCounter++;

		// address
		panels[oPutCounter + 1] = new Panel(new GridLayout(1, 4));
		outputNames[oPutCounter].setText("Address:");
		panels[oPutCounter + 1].add(outputNames[oPutCounter]);
		panels[oPutCounter + 1].add(outputs[oPutCounter]);
		panels[oPutCounter + 1].add(new Label());
		panels[oPutCounter + 1].add(new Label());
		oPutCounter++;

		// gender
		panels[oPutCounter + 1] = new Panel(new GridLayout(1, 4));
		outputNames[oPutCounter].setText("Gender:");
		panels[oPutCounter + 1].add(outputNames[oPutCounter]);
		outputs[oPutCounter].setText("empty");
		panels[oPutCounter + 1].add(outputs[oPutCounter]);
		panels[oPutCounter + 1].add(new Label());
		panels[oPutCounter + 1].add(new Label());
		oPutCounter++;

		// Account type
		panels[oPutCounter + 1] = new Panel(new GridLayout(1, 4));
		outputNames[oPutCounter].setText("Account:");
		panels[oPutCounter + 1].add(outputNames[oPutCounter]);
		panels[oPutCounter + 1].add(outputs[oPutCounter]);
		panels[oPutCounter + 1].add(new Label());
		panels[oPutCounter + 1].add(new Label());
		oPutCounter++;

		// Balance
		panels[oPutCounter + 1] = new Panel(new GridLayout(1, 4));
		outputNames[oPutCounter].setText("Balance:");
		Button okBtn = new Button("OK");
		panels[oPutCounter + 1].add(outputNames[oPutCounter]);
		panels[oPutCounter + 1].add(outputs[oPutCounter]);
		panels[oPutCounter + 1].add(new Label());
		panels[oPutCounter + 1].add(new Label());
		panels[oPutCounter + 1].add(okBtn);

		// set up accNumPnl
		// (unique panel: label, textfield and button - and always visible
		panels[0] = new Panel(new GridLayout(1, 3));
		Label accNumLbl = new Label("Account Number:");
		accNumLbl.setPreferredSize(new Dimension(ELEMENT_SIZE));
		TextField AccNumTF = new TextField();
		AccNumTF.setPreferredSize(ELEMENT_SIZE);
		Button fetchAccBtn = new Button("...");
		panels[0].add(accNumLbl);
		panels[0].add(AccNumTF);
		panels[0].add(fetchAccBtn);

		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m_frame.dispose();
			}
		});

		fetchAccBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (MyConnector.checkAccountExists(AccNumTF.getText())) {
					ArrayList<String> details = MyConnector.getAcount(AccNumTF
							.getText().toUpperCase());
					if (details.size() > 0) {
						for (int i = 0; i < NUM_OF_OPUTS; i++) {
							outputs[i].setVisible(true);
							outputNames[i].setVisible(true);
						}
						String recName = details.get(1);
						outputs[0].setText(recName);

						String recAddress = details.get(2);
						outputs[1].setText(recAddress);

						String recGender = details.get(0).substring(1, 2)
								.toUpperCase();
						if (recGender.equals("M"))
							recGender = "Male";
						else if (recGender.equals("F"))
							recGender = "Female";

						outputs[2].setText(recGender);

						String recAccountType = details.get(0).substring(0, 1)
								.toUpperCase();
						if (recAccountType.equals("C"))
							recAccountType = "Current Account";
						else if (recAccountType.equals("S"))
							recAccountType = "Savings Account";
						outputs[3].setText(recAccountType);

						String recBalance = Double.toString(MyConnector
								.calculateBalance(AccNumTF.getText()
										.toUpperCase()));
						outputs[4].setText(recBalance);
					}
				} else {
					JOptionPane.showMessageDialog(m_frame,
							"Not a valid account number");
				}
			}
		});

		for (int i = 0; i < NUM_OF_ROWS; i++) {
			m_frame.add(panels[i]);
		}

		for (int i = 0; i < NUM_OF_OPUTS; i++) {
			outputs[i].setVisible(false);
			outputNames[i].setVisible(false);
		}
		m_frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				m_frame.dispose();
			}
		});
	}

	private static void initFrame(Frame m_frame) {
		m_frame.setSize(FRAME_SIZE);
		m_frame.setVisible(true);
		m_frame.addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentResized(ComponentEvent e) {
				FRAME_SIZE.setSize(m_frame.getSize());
				Dimension FRAME_SIZE = new Dimension(400, 400);
				ELEMENT_SIZE = new Dimension((FRAME_SIZE.width / 3)
						- (FRAME_SIZE.width / 10), FRAME_SIZE.height
						/ NUM_OF_ROWS);
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
