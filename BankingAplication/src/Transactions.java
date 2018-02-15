import java.awt.Button;
import java.awt.Dimension;
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

import javax.swing.JOptionPane;

public class Transactions {
	//this class will control the transaction screens - baance, deposit and withdraw
	static final int NUM_OF_ROWS = 6;//there are this many panels on the screen
	static Dimension FRAME_SIZE = new Dimension(400, 400);
	//generally an element inside the panel, ie a text field will be the ELEMENT_SIZE
	static Dimension ELEMENT_SIZE = new Dimension((FRAME_SIZE.width / 3) - (FRAME_SIZE.width / 10), FRAME_SIZE.height / NUM_OF_ROWS);
	static final int NUM_OF_NAME_TAGS = 5;//5 labels That name the fields
	static final int NUM_OF_OPUTS_LBLS = 3;//3 non-intractable lables  that will display user details
	static Label[] userDetailLbls = new Label[NUM_OF_OPUTS_LBLS];//in order Name, address and balance
	static Label[] nameTags = new Label[NUM_OF_NAME_TAGS];
	static Panel[] panels = new Panel[NUM_OF_ROWS];

	public enum ScreenType {
		BALLANCE, DEPOSIT, WITHDRAW
	}

	static ScreenType m_ScreenType;//this will be the type of transaction requested

	public static void initViewer(ScreenType screenType) {
		m_ScreenType = screenType;
		ELEMENT_SIZE = new Dimension(50, 50);
		Frame m_frame = new Frame(m_ScreenType.toString());
		initFrame(m_frame);
		m_frame.setLayout(new GridLayout(NUM_OF_ROWS, 1));

		for (int i = 0; i < NUM_OF_NAME_TAGS; i++) {
			if(i < NUM_OF_OPUTS_LBLS){
				userDetailLbls[i] = new Label("          ");
				userDetailLbls[i].setPreferredSize(ELEMENT_SIZE);
			}
			nameTags[i] = new Label("          ");
			nameTags[i].setPreferredSize(ELEMENT_SIZE);
		}

		int oPutCounter = 0;
		// name panel
		panels[oPutCounter + 1] = new Panel(new GridLayout(1, 4));
		nameTags[oPutCounter].setText("Name:");
		panels[oPutCounter + 1].add(nameTags[oPutCounter]);
		panels[oPutCounter + 1].add(userDetailLbls[oPutCounter]);
		panels[oPutCounter + 1].add(new Label());
		panels[oPutCounter + 1].add(new Label());
		oPutCounter++;

		// address
		panels[oPutCounter + 1] = new Panel(new GridLayout(1, 4));
		nameTags[oPutCounter].setText("Address:");
		panels[oPutCounter + 1].add(nameTags[oPutCounter]);
		panels[oPutCounter + 1].add(userDetailLbls[oPutCounter]);
		panels[oPutCounter + 1].add(new Label());
		panels[oPutCounter + 1].add(new Label());
		oPutCounter++;

		// Balance
		panels[oPutCounter + 1] = new Panel(new GridLayout(1, 4));
		nameTags[oPutCounter].setText("Balance:");
		Button okBtn = new Button("OK");
		panels[oPutCounter + 1].add(nameTags[oPutCounter]);
		panels[oPutCounter + 1].add(userDetailLbls[oPutCounter]);
		panels[oPutCounter + 1].add(new Label());
		panels[oPutCounter + 1].add(new Label());
		oPutCounter++;

		// Withdraw/Deposit amount
		panels[oPutCounter + 1] = new Panel(new GridLayout(1, 3));
		nameTags[oPutCounter].setText("Enter Amount:");
		TextField editAmountTF = new TextField();
		panels[oPutCounter + 1].add(nameTags[oPutCounter]);
		panels[oPutCounter + 1].add(editAmountTF);
		panels[oPutCounter + 1].add(new Label());
		oPutCounter++;

		// ok panel
		panels[oPutCounter + 1] = new Panel(new GridLayout(1, 1));
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
			public void actionPerformed(ActionEvent evt) {
				if (m_ScreenType == ScreenType.BALLANCE) {
					m_frame.dispose();
				} else {
					// user wants to deposit or withdraw an amount
					if (MyConnector.checkAccountExists(AccNumTF.getText())) {
						try {
							double editamount = Double.parseDouble(editAmountTF
									.getText());
							if (m_ScreenType == ScreenType.DEPOSIT) {
								MyConnector.deposit(editamount,
										AccNumTF.getText());
								JOptionPane
										.showMessageDialog(
												m_frame,
												editAmountTF.getText()
														+ " deposited!\n"
														+ "New balance: "
														+ MyConnector
																.calculateBalance(AccNumTF
																		.getText()));
							} else if (m_ScreenType == ScreenType.WITHDRAW) {
								if (MyConnector.checkWithdrawalPossible(
										editamount, AccNumTF.getText())) {
									MyConnector.withdraw(editamount,
											AccNumTF.getText());
									JOptionPane
											.showMessageDialog(
													m_frame,
													editAmountTF.getText()
															+ " Withdrawn \n"
															+ "New balance: "
															+ MyConnector
																	.calculateBalance(AccNumTF
																			.getText()));
								} else {
									JOptionPane.showMessageDialog(m_frame,
											"Balance too low");
									m_frame.dispose();
								}

							} else {
								System.out.println("Unknown screentype");
								JOptionPane
										.showMessageDialog(m_frame,
												"We have encountered an error. Please try again later");
							}
							m_frame.dispose();
						} catch (NumberFormatException exc) {
							JOptionPane.showMessageDialog(m_frame,
									" Please enter a valid number!");
							editAmountTF.setText("");
						} catch (Exception exc) {
							JOptionPane
									.showMessageDialog(m_frame,
											"We have encountered an error. Please try again later");
							System.out.println();
						}
					} else {
						JOptionPane.showMessageDialog(m_frame,"Not a valid account number");
					}
				}
			}
		});

		fetchAccBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(MyConnector.checkAccountExists(AccNumTF.getText()))
				{
					ArrayList<String> details = MyConnector.getAcount(AccNumTF.getText().toUpperCase());
					if (details.size() > 0) {
						for (int i = 0; i < NUM_OF_ROWS; i++) {
							if (screenType != ScreenType.BALLANCE || i != 4)
								panels[i].setVisible(true);
						}
						String recName = details.get(1);
						userDetailLbls[0].setText(recName);
	
						String recAddress = details.get(2);
						userDetailLbls[1].setText(recAddress);
	
						String balance = Double.toString(MyConnector
								.calculateBalance(AccNumTF.getText().toUpperCase()));
						userDetailLbls[2].setText(balance);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(m_frame,"Not a valid account number");
				}
			}
		});

		for (int i = 0; i < NUM_OF_ROWS; i++) {
			m_frame.add(panels[i]);
			if (i > 0)
				panels[i].setVisible(false);
		}

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
		m_frame.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent we) 
	        {m_frame.dispose();}});

	}

}
