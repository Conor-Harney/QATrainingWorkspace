
public class Source {
	
	
	public static void main(String Args[])
	{
		/*WhileToFor wtf = new WhileToFor();
		
		System.out.println("AByATimesLoop:");
		wtf.AByATimesLoop();
		System.out.println("\n \n \n");
		
		System.out.println("OddsAndEvens");
		wtf.OddsAndEvens();
		System.out.println("\n \n \n");
		
		System.out.println("printTimesTableToMax");
		wtf.printTimesTableToMax(3, 6);
		System.out.println("\n \n \n");
		
		System.out.println("printTimesTable");
		wtf.printTimesTable(4);
		System.out.println("\n \n \n");*/
		
		runCaseStatment(10);
	}
	
	static void runCaseStatment(int dayOfTheWeek)
	{	
		switch (dayOfTheWeek)
		{
		default:
			System.out.println("Try the below");
		case 1:
			System.out.println("Work");
			break;
		case 2:
			System.out.println("Sleep");
			break;
		case 3:
			System.out.println("Exercise");
			break;
		case 4:
			System.out.println("Eat");
			break;
		}
	}
}
