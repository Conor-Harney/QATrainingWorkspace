import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

import javax.swing.*;
import javax.swing.SpringLayout.Constraints;

public class Source {

	public static void main(String args[]) {
		JFrame m_frame = new JFrame("Bankking app");
		JMenuBar m_menuBar1 = new JMenuBar();
		
		// transaction menu
		JMenu m_accountnMenu = new JMenu("Account");
		JMenuItem AccOpen_MItm = new JMenuItem("Account Open");
		JMenuItem AccDetails_MItm = new JMenuItem("Account Details");
		AccOpen_MItm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CreateAccount.initWindow();

			}
		});
		AccDetails_MItm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DisplayAccount.initViewer();

			}
		});
		
		m_menuBar1.add(m_accountnMenu);
		m_accountnMenu.add(AccOpen_MItm);
		m_accountnMenu.add(AccDetails_MItm);
		m_accountnMenu.setSize(m_frame.getWidth() / 3, m_frame.getHeight() / 10);
		// transaction menu
		// transaction menu
		JMenu m_transactionMenu = new JMenu("Transaction");
		JMenuItem balance_MItm = new JMenuItem("Check Balance");
		JMenuItem withdraw_MItm = new JMenuItem("Withdraw");
		JMenuItem deposit_MItm = new JMenuItem("Deposit");
		balance_MItm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Transactions.initViewer(Transactions.ScreenType.BALLANCE);
			}
		});
		withdraw_MItm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Transactions.initViewer(Transactions.ScreenType.WITHDRAW);
			}
		});
		deposit_MItm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Transactions.initViewer(Transactions.ScreenType.DEPOSIT);
			}
		});
		m_transactionMenu.addSeparator();
		m_menuBar1.add(m_transactionMenu);
		m_transactionMenu.add(balance_MItm);
		m_transactionMenu.add(withdraw_MItm);
		m_transactionMenu.add(deposit_MItm);
		

		m_frame.add(m_menuBar1, BorderLayout.NORTH);
		m_frame.setVisible(true);
		m_frame.setSize(800, 800);
		
		m_frame.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent we) 
	        {m_frame.dispose();}});

	}

	public static void createAccount(String name, String address,
			String gender, String accountType) {
		System.out.println(name + address + gender + accountType);

		MyConnector.createAccount(name, address, gender, accountType);

	}

}
