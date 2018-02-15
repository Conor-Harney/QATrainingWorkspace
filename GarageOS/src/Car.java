import java.awt.Color;

public class Car extends Vehicle {

	public Car(int weight, int numOfAxel, float value, Color color) {
		super(weight, numOfAxel, value, color);
		
	}
	
	public void deployAirbag()
	{
		System.out.println("airbag deployed");
	}
	

}
