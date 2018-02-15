public class Tax {
	
	public void printTaxRate(int salary)
	{//print the percent tax
		float ratePercent;
		if(salary < 10000)
			ratePercent = 0;
		else if(salary < 20000)
			ratePercent = 15;
		else if(salary < 30000)
			ratePercent = 21;
		else if(salary < 40000)
			ratePercent = 35;
		else if(salary < 50000)
			ratePercent = 42;
		else 
			ratePercent = 52;
		
		System.out.println("Tax rate = " + ratePercent + "%" );
	}
	
	public void printCalculateTax(int salary) 
	{
		float ratePercent;
		if(salary < 10000)
			ratePercent = 0;
		else if(salary < 20000)
			ratePercent = 15;
		else if(salary < 30000)
			ratePercent = 21;
		else if(salary < 40000)
			ratePercent = 35;
		else if(salary < 50000)
			ratePercent = 42;
		else 
			ratePercent = 52;
		float tax = (float)(salary / 100) * ratePercent;
		System.out.println("Tax = £" + tax);
	}

	public float getTaxRate(int salary)
	{//return the percent tax
		float ratePercent;
		if(salary < 10000)
			ratePercent = 0;
		else if(salary < 20000)
			ratePercent = 15;
		else if(salary < 30000)
			ratePercent = 21;
		else if(salary < 40000)
			ratePercent = 35;
		else if(salary < 50000)
			ratePercent = 42;
		else 
			ratePercent = 52;
		
		return ratePercent;
	}
	
	public float getTax(int salary) {
		float tax = (float)(salary / 100) * getTaxRate(salary);
		return tax;
	}
}
