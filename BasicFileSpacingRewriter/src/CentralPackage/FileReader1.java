package CentralPackage;


import java.util.Scanner;

public class FileReader1 {
	String fileName = "";
	
	public static void readFile()
	{
		Scanner nameScanner = new Scanner(System.in);
	    String fileName = nameScanner.nextLine();
	    nameScanner.close();
	    
	    System.out.println(fileName);
	}
}
