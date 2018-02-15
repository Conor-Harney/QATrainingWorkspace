
public class MethodOverloader {
	//default constructor will only be created if no others exist.
	
	float m_a, m_b;
	
	public MethodOverloader() {
		m_a = 0;
		m_b = 0;
	}
	public MethodOverloader(int a)
	{
		m_a = a;
		m_b = 0;
		
		System.out.println("called int constructor");
	}
	public MethodOverloader(float a)
	{
		m_a = a;
		System.out.println("called float constructor");
		
	}
	public float getM_a() {
		return m_a;
	}
	public void setM_a(float m_a) {
		this.m_a = m_a;
	}
	public float getM_b() {
		return m_b;
	}
	public void setM_b(float m_b) {
		this.m_b = m_b;
	}
	public MethodOverloader(int a, int b)
	{
		m_a = a;
		m_b = b;
	}
	
	public void printVars()
	{
		System.out.println("m_a = " + m_a);
		System.out.println("m_b = " + m_b);
	}
	
	public void printVars(String message)
	{
		System.out.println(message);
		System.out.println("m_a = " + m_a);
		System.out.println("m_b = " + m_b);
	}
}
