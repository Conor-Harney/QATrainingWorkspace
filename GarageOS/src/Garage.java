import java.util.ArrayList;

public class Garage {
	private ArrayList<Vehicle> m_vehicles; 
	
	public Garage()
	{
		
	}
	public void addVehicle(Vehicle vehicle)
	{
		m_vehicles.add(vehicle);
	}
	public Vehicle removeVehicle(int VehicleID)
	{
		for(Vehicle v:m_vehicles)
		{
			if ( v.getID() == VehicleID)
			{
				return v;
			}
		}
		return null;
		
	}
}
