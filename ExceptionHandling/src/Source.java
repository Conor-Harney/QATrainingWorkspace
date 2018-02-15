
public class Source {
	
	public static void main(String Args[])
	{
		try {
			int a = 7/0;
		}
		catch(ArithmeticException x)
		{
			System.out.println("Error found");
			x.printStackTrace();
			System.out.println("Error type: " + x.getMessage());
			StackTraceElement[] myTracer = x.getStackTrace();
			System.out.println("there are "+ myTracer.length + " Errors");
			for(int i = 0; i < myTracer.length; i++)
			{
				System.out.println("Error " + myTracer.length);
				System.out.println("Method: " + myTracer[i].getMethodName());
				System.out.println("Class name: " + myTracer[i].getClassName());
				System.out.println("File name: " + myTracer[i].getFileName());
				System.out.println("Line number: " + myTracer[i].getLineNumber());
			}
		}
		System.out.println("I have continued");
	}

}
