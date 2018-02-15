import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.naming.StringRefAddr;

import com.mysql.jdbc.BalanceStrategy;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MyConnector {
	
	static String DB_NAME = "jdbc:mysql://localhost:3306/Banking";
	static String DB_USERNAME = "root";
	static String DB_PASSWORD = "";

	public static String getNextAccNumber()
	{
		String retStr = "100";
		try {
			Connection con = (Connection)DriverManager.getConnection(
					DB_NAME, DB_USERNAME , DB_PASSWORD);
			Statement stmt = (Statement)con.createStatement();
			
			
			
			String gender = "M";
			String accountType = "C";
			ResultSet rs = stmt.executeQuery("select concat( '" + accountType + "' , '" + gender + "' , ifnull( lpad( max( (substr( AccountNo, 3, 3)) + 1), 3, '0'),  '101')) from Accounts;");
			while(rs.next())
			{
				retStr = rs.getString(1);;
			}
			con.close();
		}catch(NumberFormatException e)
		{
			System.out.println(e);
			System.out.println(e.getStackTrace()[0].getClassName());
		    System.out.println(e.getStackTrace()[0].getLineNumber());
		    System.out.println("Error finding next account number - invalid number passed");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			System.out.println(e.getStackTrace()[0].getClassName());
		    System.out.println(e.getStackTrace()[0].getLineNumber());
		    System.out.println("Error finding next account number");
		}
		
		return retStr;
		
	}

	private static void post(String statement) {
		try {
			Connection con = (Connection) DriverManager.getConnection(
					DB_NAME, DB_USERNAME, DB_PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			stmt.executeUpdate(statement);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("error occured");
		}
	}

	public static void printTable(String tablename) {
		ArrayList<ArrayList<String>> myal = MyConnector.get("select * from "
				+ tablename + ";");
		for (int i = 0; i < myal.size(); i++) {
			for (int o = 0; o < myal.get(i).size(); o++) {
				String tempStr = myal.get(i).get(o);
				System.out.println(tempStr);
			}

		}
	}

	private static ArrayList<ArrayList<String>> get(String statement) {
		ArrayList<ArrayList<String>> outterArray = new ArrayList<ArrayList<String>>(
				0);

		try {
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = (Connection) DriverManager.getConnection(
					DB_NAME, DB_USERNAME, DB_PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(statement);
			while (rs.next()) {
				int count = rs.getMetaData().getColumnCount();
				ArrayList<String> innerArray = new ArrayList<String>();
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					try {
						innerArray.add(rs.getString(i));
					} catch (Exception e1) {
						try {
							innerArray.add(Integer.toString(rs.getInt(i)));
						} catch (Exception e2) {
							System.out.println("not int or string");
						}
					}
				}
				outterArray.add(innerArray);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getStackTrace()[0].getClassName());
			System.out.println(e.getStackTrace()[0].getLineNumber());
			System.out.println("Error getting generic get statment");
		}
		return outterArray;
	}

	public static ArrayList<String> getAcount(String accountNO) {
		ArrayList<String> retAry = new ArrayList<String>();
		try {
			accountNO = normilizeAccNum(accountNO);
			Connection con = (Connection) DriverManager.getConnection(
					DB_NAME, DB_USERNAME, DB_PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from Accounts where AccountNo = '"
							+ accountNO + "';");
			while (rs.next()) {
				retAry.add(rs.getString(1));
				retAry.add(rs.getString(2));
				retAry.add(rs.getString(3));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getStackTrace()[0].getLineNumber());
			System.out.println(e.getStackTrace()[0].getClassName());
			System.out.println("error finding account");
		}
		return retAry;
	}

	public static String createAccount(String name, String address, String accountType, String gender)
	{
		//make sure the input is M, F, C, S
		gender = gender.substring(0, 1).toUpperCase();
		accountType = accountType.substring(0, 1).toUpperCase();
		String accountNo = "";
		
		try {
			Connection con = (Connection)DriverManager.getConnection(DB_NAME, DB_USERNAME , DB_PASSWORD);//connect
			Statement stmt = (Statement)con.createStatement();//set up connection statement
			//get the all account numbers, get the numeric section, get the max,add 1 and pad it to be three characters long. then add the prefix type and gender.
			ResultSet rs = stmt.executeQuery("select concat( '" + accountType + "' , '" + gender + "' , ifnull( lpad( max( (substr( AccountNo, 3, 3)) + 1), 3, '0'),  '101')) from Accounts Where substr(accountNo, 1,1) = '" + accountType +"';");
			while(rs.next())
			{
				accountNo = rs.getString(1);
			}
			stmt.executeUpdate("insert into Accounts(AccountNo, Name, Address) values('" + accountNo + "', '"+ name +"', '" + address +"' )");
			con.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		    System.out.println("Account not created");
		}
		
		if(accountNo.equals(""))
			accountNo = "Account not created, please try again later";
		return accountNo;
	}
	
	public static double calculateBalance(String accountNo)
	{
		double returnBalance = 0;
		
		try {
			accountNo = normilizeAccNum(accountNo);
			Connection con = (Connection) DriverManager.getConnection(DB_NAME, DB_USERNAME, DB_PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = 
					stmt.executeQuery("select ((select ifnull(sum(Amount),0) from transactions where TransactionType = 'D' and AccountNumber = '"+accountNo+"') "
							+ "- (select ifnull(sum(Amount),0) from transactions where TransactionType = 'W' and AccountNumber = '"+accountNo+"')) as total;");
			while (rs.next()) {
				returnBalance= Double.parseDouble(rs.getString("total"));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getStackTrace()[0].getClassName());
			System.out.println(e.getStackTrace()[0].getLineNumber());
			System.out.println("balance calculation failure");
		}
		
		return returnBalance;
		
	}

	public static boolean checkAccountExists(String accountNumber)
	{
		int found = 0;
		try {
			accountNumber = normilizeAccNum(accountNumber);
			Connection con = (Connection) DriverManager.getConnection(DB_NAME, DB_USERNAME, DB_PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			String statement = "select count(AccountNo) from Accounts where AccountNo = '"+accountNumber+"';";
			ResultSet rs = stmt.executeQuery(statement);
			while(rs.next()){
				found = Integer.parseInt(rs.getString(1));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Account does not exist - error");
		}
		if(found > 0) return true;
		else return false;
	}
	
	private static String normilizeAccNum(String accNum)
	{
		return accNum.replaceAll("\\s+","").toUpperCase();
	}
	
	public static boolean deposit(double amount, String accountNo)
	{
		accountNo = normilizeAccNum(accountNo);
		boolean success = false;
		if(checkAccountExists(accountNo))
		{
			try {
				Connection con = (Connection) DriverManager.getConnection(DB_NAME, DB_USERNAME, DB_PASSWORD);
				Statement stmt = (Statement) con.createStatement();
				String currentDate = LocalDate.now().toString();
				
				String statement = "insert into transactions (`AccountNumber`, `TransactionType`, `Amount`, `Date`) "
						+ "VALUES ( '"+ accountNo +"' , 'D', '" + Double.toString(amount) + "', '"+ currentDate +"')";
				stmt.executeUpdate(statement);
				con.close();
				success = true;
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("error occured");
			}
		}
		return success;
	}
	
	public static boolean checkWithdrawalPossible(double ammountToWithdraw, String accNum)
	{
		return (calculateBalance(normilizeAccNum(accNum)) > ammountToWithdraw);
	}
	
	public static boolean withdraw(double amount, String accountNo)
	{
		accountNo = normilizeAccNum(accountNo);
		boolean success = false;
		if(checkAccountExists(accountNo))
		{
			try {
				Connection con = (Connection) DriverManager.getConnection(DB_NAME, DB_USERNAME, DB_PASSWORD);
				Statement stmt = (Statement) con.createStatement();
				String currentDate = LocalDate.now().toString();
				
				String statement = "insert into transactions (`AccountNumber`, `TransactionType`, `Amount`, `Date`) "
						+ "VALUES ( '"+ accountNo +"' , 'W', '" + Double.toString(amount) + "', '"+ currentDate +"')";
				stmt.executeUpdate(statement);
				con.close();
				success = true;
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("error occured");
			}
		}
		return success;
	}
	
}
