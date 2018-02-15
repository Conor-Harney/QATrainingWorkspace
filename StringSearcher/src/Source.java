
public class Source {
	
	public static void main(String args[])
	{
		StringSearcher1 ss1 = new StringSearcher1();
		String myString = "Hello, how are you?";
		//System.out.println(ss1.countWords(myString));
		//ss1.printWordByLine(myString);
		ss1.printWordByLineReversed(myString);
	}

}
