
public class Source {
	
	public static void printSalaryDetails(Tax taxCalculator, int salary)
	{
		System.out.println("When salary = "+salary);
		System.out.println("Get tax returns " + taxCalculator.getTax(salary));
		System.out.println("using a rate of " + taxCalculator.getTaxRate(salary));
	}
	
	public static void main(String args[])
	{
		/*Tax taxCalculator = new Tax();
		taxCalculator.taxRate(20000);
		taxCalculator.calculateTax(40000);
		taxCalculator.calculateTax(900000);
		taxCalculator.calculateTax(28000);
		taxCalculator.calculateTax(3000);
		*/
		
		Tax taxCalculator = new Tax();
		printSalaryDetails(taxCalculator, 19500);
		printSalaryDetails(taxCalculator, 28000);
		printSalaryDetails(taxCalculator, 80000);
		
	}
	
	
	
}
