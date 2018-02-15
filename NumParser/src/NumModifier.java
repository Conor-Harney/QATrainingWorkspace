
public class NumModifier {

	public void parseNum(int a) {// this code will only accept a number 1 to 99
		//groups of three
		int counter = 0;
		String name = "";
		if(a == 0) {name = "Zero";}
		String inputInStr = Integer.toString(a);
		String strToParse = "";
		String thisRoundsValue1 = "";
		int lenghtChecker = 3;
		if(inputInStr.length() >= lenghtChecker + 1)
		{
			thisRoundsValue1 = "";
			strToParse = inputInStr.substring(0, inputInStr.length() - lenghtChecker);
			inputInStr = inputInStr.substring(inputInStr.length() - lenghtChecker, inputInStr.length());
			thisRoundsValue1 =  ParseTwoDigit(Integer.parseInt(strToParse));
			thisRoundsValue1 += " thousand, ";
			name += thisRoundsValue1;
			
		}
		lenghtChecker = 2;
		if(inputInStr.length()  == lenghtChecker+1)
		{
			thisRoundsValue1 = "";
			strToParse = inputInStr.substring(0, inputInStr.length() - lenghtChecker);
			inputInStr = inputInStr.substring(inputInStr.length() - lenghtChecker, inputInStr.length());
			thisRoundsValue1 =  ParseTwoDigit(Integer.parseInt(strToParse));
			if (thisRoundsValue1.length() > 0)
			thisRoundsValue1 += " hundred ";
			name += thisRoundsValue1;
		}
		if(name.length() > 0) name = name + "and ";
		lenghtChecker = 0;
		if(inputInStr.length() > lenghtChecker)
		{
			thisRoundsValue1 = "";
			strToParse = inputInStr.substring(0, inputInStr.length() - lenghtChecker);
			inputInStr = inputInStr.substring(inputInStr.length() - lenghtChecker, inputInStr.length());
			thisRoundsValue1 =  ParseTwoDigit(Integer.parseInt(strToParse));
			name += thisRoundsValue1;
		} 
		
		System.out.println(name);
		
		/*
		for(String numString = Integer.toString(a); numString.length() >= 2; )
		{
			String twoDigitStr = numString.substring(numString.length() - 2, numString.length());
			numString = numString.substring(0, (numString.length() - 2));
			if(numString.length() > 0) {
				a = Integer.parseInt(numString);
			}
			else
				a = 0;
			int twoDig = Integer.parseInt(twoDigitStr);
			String thisRoundsValue = ParseTwoDigit(twoDig);
			
			
			
			if(counter == 1)
				thisRoundsValue += " hundred ";
			else if (counter == 2)
				thisRoundsValue += " thouusand ";
				
			counter++;
			name = thisRoundsValue + name;
		}
		if(a!=0) {
			String thisRoundsValue = ParseTwoDigit(a);
			if(counter == 1)
				thisRoundsValue += " hundred ";
			else if (counter == 2)
				thisRoundsValue += " thouusand ";
			name = thisRoundsValue + name;
		}
		System.out.println(name);*/
		
	}

	private String ParseTwoDigit(int numToParse) {
		while(numToParse >= 100) {
			numToParse -=100;
		}
		String name = "";
		if (numToParse >= 0 && numToParse <= 99) {
			int leftNum = 0;
			int rightNum = numToParse;
			while (rightNum >= 10) {
				rightNum -= 10;
				leftNum += 1;
			}
			name = ParseNumberoOneToTen(rightNum);

			/*if (numToParse == 0) {
				name = "Zero";

			}*/
			
			switch (leftNum) {
			case 9:
				name = "Ninty" + name;
				break;
			case 8:
				name = "Eighty" + name;
				break;
			case 7:
				name = "Seventy" + name;
				break;
			case 6:
				name = "Sixty" + name;
				break;
			case 5:
				name = "Fifty" + name;
				break;
			case 4:
				name = "Forty" + name;
				break;
			case 3:
				name = "Thirty" + name;
				break;
			case 2:
				name = "Twenty" + name;
				break;
			case 1:
				if (rightNum >= 4) {
					name += "teen";
				} else {
					switch (numToParse) {
					case 10:
						name = "Ten";
						break;
					case 11:
						name = "Eleven";
						break;
					case 12:
						name = "Twelve";
						break;
					case 13:
						name = "Thirteen";
						break;
					default:
						name = "NAN - (A)";
						break;
					}
				}
				break;
			case 0:
				break;
			default:
				name = "NAN - (Left num)";
				break;
			}
		}
		return name;
	}

	private String ParseNumberoOneToTen(int num) {
		while(num >= 10) {
			num -=1;
		}

		String result = "";
		switch (num) {
		case 9:
			result = "nine";
			break;
		case 8:
			result = "eight";
			break;
		case 7:
			result = "seven";
			break;
		case 6:
			result = "six";
			break;
		case 5:
			result = "five";
			break;
		case 4:
			result = "four";
			break;
		case 3:
			result = "three";
			break;
		case 2:
			result = "two";
			break;
		case 1:
			result = "one";
			break;
		case 0:
			//result = "zero";
			break;
		default:
			result = "NAN";
			break;

		}
		return result;
	}

}
