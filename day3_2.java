import java.util.*;
import java.io.*;

public class day3_2
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int[][] grid = new int[1000][1000];
		
		int[] nogos = new int[1350];
		nogos[0] = -1;
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
			input(grid, scan.nextLine(), nogos);
		}
		
		
		
		for (int i = 1; i < 1350; i++)
		{
			//System.out.println("claim " + 
		}
		countClaim(nogos);
		
		scan.close();
		//System.out.println(total);
		
		
		
	}
	
	public static void countClaim(int[] claims)
	{
		for (int i=1; i < 1350; i++)
		{
			if (claims[i] == 0)
				System.out.println("Candidate: " + i);
			
			
		}
		
	}
	
	public static int count(int[][] grid)
	{
		int count = 0;
		for (int i = 0; i < 1000; i++)
		{
			for (int j = 0; j < 1000; j++)
			{
				if (grid[i][j] > 1)
					return grid[i][j];
			
			}
			
			
		}
		return -1;
	}
	
	public static void input(int[][] grid, String str, int[] nogos)
	{
		//System.out.println(str);
		
		
		
		int claim = Integer.parseInt(            (str.split(" ")[0]).substring(1)           );
		
		
		
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
		
		System.out.println("Claim " + claim + ":");
		
		for (int i = cx; i < cx + sx; i++)
		{
			for (int j = cy; j < cy + sy; j++)
			{
				if (grid[i][j] == 0)
				{
					grid[i][j] = claim;
				}
				else
				{
					if (grid[i][j] > 0)
						nogos[grid[i][j]] = -1;
					grid[i][j] = -1;
					//System.out.println("grid["+i+"]["+j+"] :" + grid[i][j]);
					//if (grid[i][j] > 0)
					//	nogos[grid[i][j]] = -1;
					System.out.println("Claim " + claim + " nogood");
					nogos[claim] = -1;
				}
			}
		}
	}
	
	
}