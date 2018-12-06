import java.util.*;
import java.io.*;

public class day3_1
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int[][] grid = new int[1000][1000];
		try
		{
			scan = new Scanner(new File("in3.txt"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		while(scan.hasNext())
		{
			input(grid, scan.nextLine());
		}
		
		
		
		System.out.println(count(grid));
		
		scan.close();
		//System.out.println(total);
		
		
		
	}
	
	public static int count(int[][] grid)
	{
		int count = 0;
		for (int i = 0; i < 1000; i++)
		{
			for (int j = 0; j < 1000; j++)
			{
				if (grid[i][j] > 1)
					count++;
			
			}
			
			
		}
		return count;
	}
	
	public static void input(int[][] grid, String str)
	{
		System.out.println(str);
		String nums = str.split("@ ")[1];
		
		int cx;
		int cy;
		int sx;
		int sy;
		String commas[] = nums.split(",");
		cx = Integer.parseInt(commas[0]);
		
		
		
		String colons[] = commas[1].split(": ");
		cy = Integer.parseInt(colons[0]);
		
		
		
		
		String xes[] = colons[1].split("x");
		sx = Integer.parseInt(xes[0]);
		
		
		sy = Integer.parseInt(xes[1]);
		
		System.out.println(cx + " " + cy + " " + sx + " " + sy);
		
		
		
		for (int i = cx; i < cx + sx; i++)
			for (int j = cy; j < cy + sy; j++)
				grid[i][j]++;
		
	}
	
	
}