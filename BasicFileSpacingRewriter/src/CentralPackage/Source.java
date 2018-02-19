package CentralPackage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Source {

	public static void main(String[] args) {
		//FileReader1.readFile();
		//System.out.println("one");
		PrintWriter writer;
		try {
			writer = new PrintWriter("SpacedFile.txt", "UTF-8");
			writer.println("args[0]");
			
			writer.close();
			//System.out.println("two");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("three");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("four");
		}
		
	}

}
