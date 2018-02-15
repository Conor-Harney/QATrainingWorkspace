
public class Conversion {
	
	public int toDecimal(String binary)
	{
		int dec = 0;//the number that will return
		int multiplier = 1;//multiply the binary char by multiplier and then multiply multiplier by 2  
		while(binary.length() > 0)
		{
			String currentChar = binary.substring(binary.length() - 1, binary.length());
			binary = binary.substring(0, binary.length()-1);//take off the last char
			
			int curNum;
			if(currentChar.equals("1")) curNum = 1;
			else curNum = 0;
			//curNum is in binary
			
			curNum*=  multiplier;//curNum is in dec
			multiplier *= 2; 
			dec += curNum;
		}
		return dec;
	}

	public String toBinary(int dec)
	{//change a dec number to a string of binary characters
		String binary = "";//the string that will return
		while(dec >= 1)//there is one left to convert. avoid 0.5 downwards 
		{
			int binaryChar = dec % 2;//get the remainder of the devision (1 or 0)
			dec /= 2;//half the current decimal amount, truncate any remainder 
		
			binary = binaryChar + binary;//add the char to one or zero left of the string 
		}
		return binary;
		
	}

}
