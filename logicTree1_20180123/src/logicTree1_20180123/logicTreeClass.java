package logicTree1_20180123;

public class logicTreeClass {
	void executeTree(int no)
	{
		if(no > 2000)
		{
			System.out.println(2);
			if(no > 5000)
			{
				System.out.println(3);
				if(no > 6000)
				{
					System.out.println(5);
				}
				else
				{
					System.out.println(4);
				}
			}
			else
			{
				System.out.println(3);
				if(no > 7000)
				{
					System.out.println(7);
				}
				else
				{
					System.out.println(8);
				}
			}
		}
		else
		{
			System.out.println(1);
			if(no<500)
			{
				System.out.println(9);
				if(no > 100)
				{
					System.out.println("A");
				}
				else
				{
					System.out.println("B");
				}
			}
			else
			{
				System.out.println("C");
				
			}
		}
	}
}
