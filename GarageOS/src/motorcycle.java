import java.awt.Color;

public class motorcycle extends Vehicle {

	public motorcycle(int weight, int numOfAxel, float value, Color color) {
		super(weight, numOfAxel, value, color);
		// TODO Auto-generated constructor stub
	}
	
	public void FallOver()
	{
		System.out.println("Motorbike reg " + m_ID + " fell over... because motorbikes do that.");
	}
	public void deployKickstand()
	{
		System.out.println("Kickstand deployed");
	}

}
