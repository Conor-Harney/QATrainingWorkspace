
public class StringSearcher1 {
	
	public int countWords(String sentance)
	{
		int counter = 0;//number of words
		String previousChar = "";
		
		for(int i = 0; i < sentance.length(); i++)
		{
			String currentCharacter = sentance.substring(i, (i + 1));
			if(previousChar.equals("") || previousChar.equals(" "))
			{
				if(!currentCharacter.equals("") && !currentCharacter.equals(" "))
				{
					counter++;
				}
			}
			
			previousChar = currentCharacter;
		}
		
		return counter;
	}

	public void printWordByLine(String myString)
	{//print all the words on different lines 
		String previousChar = "";
		String currentWord = "";
		for(int i = 0; i < myString.length(); i++)
		{//Iterate through the characters in the string
			String currentCharacter = myString.substring(i, (i + 1));
			if(currentCharacter.equals(" "))
			{// you are on a space
				if(!previousChar.equals("") && !previousChar.equals(" "))
				{// word finished
					System.out.println(currentWord);
					currentWord = "";//begin a new word
				}
			}
			else
			{//you are on a letter or non space character
				currentWord += currentCharacter;
			}
			previousChar = currentCharacter;
		}
		if(currentWord.length() > 0)
		{//print the last word if there is something to print 
			System.out.println(currentWord);
		}
	}
	public void printWordByLineReversed(String myString)
	{//print all the words on different lines, but last to first 
		String finalString = "";
		String previousChar = "";
		String currentWord = "";
		for(int i = 0; i < myString.length(); i++)
		{//Iterate through the characters in the string
			String currentCharacter = myString.substring(i, (i + 1));
			if(currentCharacter.equals(" "))
			{// you are on a space
				if(!previousChar.equals("") && !previousChar.equals(" "))
				{// word finished
					finalString = currentWord + "\n" + finalString; //add the new word, followed by a brake-line, to the front of the string 
					currentWord = "";//begin a new word
				}
			}
			else
			{//you are on a letter or non space character
				currentWord += currentCharacter;
			}
			previousChar = currentCharacter;
		}
		if(currentWord.length() > 0)
		{//print the last word if there is something to print 
			finalString = currentWord + "\n" + finalString; 
		}
		System.out.println(finalString);
	}
	
	public void printWordByLineReversed2(String myString)
	{//unfinished
		char previousChar = ' ';
		String currentWord;
		for(int i = myString.length(); i > 0; i--)
		{
			
			
		}
	}
}
