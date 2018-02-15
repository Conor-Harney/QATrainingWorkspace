
public class QA {

	public static void showResults()
	{
		Results2 r2 = new Results2();
		r2.doCalculations();
		System.out.println("total marks: " + r2.tot);
		System.out.println("persentage: " + r2.per);
	}
	
	public static void main(String args[])
	{
		/*Results Peter;
		Peter = new Results();
		Peter.phy = 75;
		Peter.mat = 75;
		Peter.che = 100;
		Peter.Display();
		
		System.out.println(Peter.toString());*/
		
		
		/*showResults();*/
		
		Results2 resultsManager = new Results2();
		resultsManager.doCalculations();
		resultsManager.showResults();
		
	}
	
	
}
