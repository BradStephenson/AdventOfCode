import java.util.*;
import java.io.*;

public class day1_1
{
	public static void main(String args[])
	{
		Scanner scan;
		int total = 0;
		try
		{
			scan = new Scanner(new File("in1_1.txt"));
			//for (int i = 0; i < 5; i++)
			//{
			//	System.out.println(scan.nextInt());	
			//}
			while(scan.hasNext())
			{
				total += scan.nextInt();
			}
			scan.close();
			System.out.println(total);
		}
		catch(Exception e)
		{
			System.exit(0);
		}
		
	}
	
	
}