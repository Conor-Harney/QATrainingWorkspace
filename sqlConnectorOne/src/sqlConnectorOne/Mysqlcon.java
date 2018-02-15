package sqlConnectorOne;


import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class Mysqlcon {
	
	public static void main(String args[]) {
		try {
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = (Connection)DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Banking", "root" , "");
			Statement stmt = (Statement)con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from temp");
			while(rs.next())
			{
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
			con.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		    System.out.println("Happened");
		}
	}

}
