
public class ChangeCounter {
	
	public static void ProcessChange(float price, float moneyGiven)
	{
		System.out.println("Price: " + price);
		System.out.println("Money given: " + moneyGiven);
		float balance = moneyGiven - price;
		System.out.println("Current balance: " + balance);
		balance = getChangeOfType(50, balance);
		balance = getChangeOfType(20, balance);
		balance = getChangeOfType(10, balance);
		balance = getChangeOfType(5, balance);
		balance = getChangeOfType(2, balance);
		balance = getChangeOfType(1, balance);
		balance = getChangeOfType(0.50f, balance);
		balance = getChangeOfType(0.20f, balance);
		balance = getChangeOfType(0.10f, balance);
		balance = getChangeOfType(0.05f, balance);
		balance = getChangeOfType(0.02f, balance);
		balance = getChangeOfType(0.01f, balance);
	}
	
	private static float getChangeOfType(float legalTenderValue, float currentBallance)
	{
		int i;
		for(i = 0; currentBallance > legalTenderValue; i++)
		{
			currentBallance -= legalTenderValue;
		}
		if(i > 0)
			System.out.println("Return " + i + " £" + legalTenderValue + "'s");
		return currentBallance;
	}
	

}
