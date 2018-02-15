import java.awt.Color;

public abstract class Vehicle {
	static int m_nextAvaiibleID = 0;
	int m_weight;
	int m_numOfAxels;
	float m_value;
	Color m_color;
	int m_ID; 
	
	public int getID() {
		return m_ID;
	}

	public Vehicle(int weight, int numOfAxel, float value, Color color) {
		m_ID = m_nextAvaiibleID;
		m_nextAvaiibleID++;
		m_weight = weight;
		m_numOfAxels = numOfAxel;
		m_value = value;
		m_color = color;
	}
	
	public void beepHorn()
	{
		System.out.println("beep");
	}
	

}