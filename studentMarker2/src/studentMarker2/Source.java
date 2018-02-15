package studentMarker2;

public class Source {
	public static void main(String args[])
	{
		Results instance = new Results();
		instance.setPhy(200);
		instance.setPhy(10);
		instance.setChe(-7);
		instance.setChe(20);
		instance.setMat(1400);
		instance.doCalculations();
		instance.showResults();
		instance.setMat(20);
		instance.doCalculations();
		instance.showResults();
	}
}
