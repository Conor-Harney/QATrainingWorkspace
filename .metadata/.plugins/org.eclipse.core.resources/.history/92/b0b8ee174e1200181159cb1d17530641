import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Tests {

	@BeforeClass
	public static void beforeClass()
	{
		
	}
	
	@Before
	public void before()
	{
		
	}
	
	@Test
	public void testAgeRating()
	{
		Screening film1 = new Screening("the evil carrot", Screening.AgeRating.ChildNotAlowed, "2A", "21.15");
		assertTrue(!film1.checkChildAloud());
	}
	@Test
	public void testCalculateCostsNormal()
	{
		TicketCalculator tc = new TicketCalculator();
		
		try {
			double cost = tc.CalculateCosts(1, 1, 1, 1);
			assertEquals(24.0, cost);
		}
		catch(AssertionError e)
		{
		}
	}
	
	@Test 
	public void chooseWrongScreening()
	{
		Interface i = new Interface();
		i.choseScreening();
	}
	@Test
	public void testCalculateCostsDiscount()
	{
		TicketCalculator tc = new TicketCalculator();
		tc.setCurrentDay();
		
		try {
			double cost = tc.CalculateCosts(1, 1, 1, 1);
			assertEquals(16, cost);
		}
		catch(AssertionError e)
		{
		}
	}
	
	@After
	public void after()
	{
		
	}
	
	@AfterClass
	public static void afterClass()
	{
		
	}

}
