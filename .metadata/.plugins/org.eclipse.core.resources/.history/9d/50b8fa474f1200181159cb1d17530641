import java.util.Calendar;
import java.util.Vector;

public class TicketCalculator {
	
	
	Vector<String> m_priceList = new Vector<String>();//this list of prices will correspond to the customer type list 
	final Vector<String> m_customerTypes = new Vector<String>();
	public enum DAYS{ Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday};
	private DAYS m_currentDay = DAYS.Monday;
	
	public DAYS getCurrentDay() {
		return m_currentDay;
	}

	@SuppressWarnings("deprecation")
	public void setCurrentDay() {
		switch(Calendar.getInstance().getTime().getDay())
		{
		case 1:
			this.m_currentDay = DAYS.Monday;
		case 2:
			this.m_currentDay = DAYS.Tuesday;
		case 3:
			this.m_currentDay = DAYS.Wednesday;
		case 4:
			this.m_currentDay = DAYS.Thursday;
		case 5:
			this.m_currentDay = DAYS.Friday;
		case 6:
			this.m_currentDay = DAYS.Saturday;
		case 0:
			this.m_currentDay = DAYS.Sunday;
		}
	}

	public TicketCalculator()
	{
		m_priceList.add("8");
		m_customerTypes.add("Standard");
		m_priceList.add("6");
		m_customerTypes.add("OAP");
		m_priceList.add("6");
		m_customerTypes.add("Student");
		m_priceList.add("4");
		m_customerTypes.add("Child");
	}
	
	public Double CalculateCosts(int numOfStdTickets, int NumOfOPATickets, int NumOfStudentTickets, int NumOfChildTickets)
	{
		
		double total = 0;
		total -= CheckForDiscountAmount(numOfStdTickets, NumOfOPATickets, NumOfStudentTickets, NumOfChildTickets);
		total += numOfStdTickets * Double.parseDouble(m_priceList.get(0));
		total += NumOfOPATickets * Double.parseDouble(m_priceList.get(1));
		total += NumOfStudentTickets * Double.parseDouble(m_priceList.get(2));
		total += NumOfChildTickets * Double.parseDouble(m_priceList.get(3));
		
		return total;
	}
	
	private double CheckForDiscountAmount(int numOfStdTickets, int NumOfOPATickets, int NumOfStudentTickets, int NumOfChildTickets)
	{
		double discount = 0;
		if(m_currentDay == DAYS.Wednesday)
		{
			discount += superWedensdayDiscount(numOfStdTickets, NumOfOPATickets, NumOfStudentTickets, NumOfChildTickets);
		}
		
		return discount;
	}
	
	private double superWedensdayDiscount(int numOfStdTickets, int NumOfOPATickets, int NumOfStudentTickets, int NumOfChildTickets)
	{
		int ticketsRequested = numOfStdTickets+ NumOfOPATickets + NumOfStudentTickets+ NumOfChildTickets;
		return ticketsRequested*2;
	}
}
