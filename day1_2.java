import java.util.*;
import java.io.*;

public class day1_2
{
	public static void main(String args[])
	{
		Scanner scan;
		int total = 0;
		int pos[] = new int[1000000];
		int neg[] = new int[1000000];
		try
		{
			//scan = new Scanner(new File("in1_1.txt"));
			//for (int i = 0; i < 5; i++)
			//{
			//	System.out.println(scan.nextInt());	
			//}
			while(true)
			{
				scan = new Scanner(new File("in1_1.txt"));
				while(scan.hasNext())
				{
					total += scan.nextInt();
					if (total < 0)
					{
						if (neg[0 - total] == 5)
						{
							System.out.println(total);
							System.exit(0);
						}
						neg[0 - total] = 5;
					}
					else
					{
						if (pos[total] == 5)
						{
							System.out.println(total);
							System.exit(0);
						}
						pos[total] = 5;
					}
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println("issue:" + e.getMessage());
			System.exit(0);
		}
		
	}
	
	
}