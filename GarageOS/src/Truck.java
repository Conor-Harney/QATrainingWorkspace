import java.awt.Color;

public class Truck extends Vehicle {
	boolean hasTrailer = false;

	public Truck(int weight, int numOfAxel, float value, Color color) {
		super(weight, numOfAxel, value, color);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public boolean isHasTrailer() {
		return hasTrailer;
	}



	public void setHasTrailer(boolean hasTrailer) {
		this.hasTrailer = hasTrailer;
	}



	public void lowerTrailerHyrdolics()
	{
		if(hasTrailer)
			System.out.println("Hydrolics deployed.");
		else
			System.out.println("No trailer attached");
	}

}
