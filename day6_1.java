import java.util.*;
import java.io.*;

public class day6_1
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> input = new ArrayList<String>();
		
		ArrayList<Point> points = new ArrayList<Point>();
		
		
		
		char[][] grid = new char[400][400];
		
		try
		{
			scan = new Scanner(new File("in6.txt"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		int xTemp, yTemp;
		
		while(scan.hasNext())
		{
			String[] ints = scan.nextLine().split(", ");
			
			xTemp = Integer.parseInt(ints[0]);
			yTemp = Integer.parseInt(ints[1]);
			System.out.println(xTemp + ", " + yTemp); 
			points.add(new Point(xTemp, yTemp));
		}
		
		
		
		
		
		
		
		
		
		
		int ii = 0;
		
		int dist = 100000;
		
		for (int j = 0; j < 400; j++)
			for (int h = 0; h < 400; h++)
			{
				dist = 100000;
				ii = 0;
				for (char i = 'A'; i < 'A' + 50; i++)
				{
					//System.out.println(i + " " + dist + " > " + points.get(ii).dist(j, h));
					if ( (points.get(ii).dist(j, h)) < dist)
					{
						//System.out.println("less");
						//System.out.println("Distance between point " + ii + " and " + h + ", " + j + " was " + points.get(ii).dist(j, h) + " and dist was " + dist);
						dist = points.get(ii).dist(j, h);
						//System.out.println(dist);
						grid[j][h] = i;
						//System.out.println(i);
						
					}
					//System.out.println("Distance between point " + ii + " and " + h + ", " + j + " was " + points.get(ii).dist(j, h));
					ii++;
				}
				
				//System.out.println("Lowest was " + dist);
				
				
				/*for (char i = 'a'; i < 'a' + 50; i++)
				{
					if (points.get(ii).dist(j, h) == dist && !(i == grid[j][h]));
						grid[j][h] = '.';
				}*/
				
				
				
				
			}
		
		
		int[] frequency = new int[50];
		int[] frequency2 = new int[50];
		
		char let = 'A';
		for (int i = 0; i < 50; i++)
		{
			
			for (int h = 0; h < 400; h++)
				for (int j = 0; j < 400; j++)
					if (grid[j][h] == let)
						frequency[i] ++;
			
			
			let++;
		}
		
		let = 'A';
		for (int i = 0; i < 50; i++)
		{
			
			for (int h = 1; h < 399; h++)
				for (int j = 1; j < 399; j++)
					if (grid[j][h] == let)
						frequency2[i] ++;
			
			
			let++;
		}
		
		for (int i = 0; i < 50; i++)
		{
			if (!(frequency[i] == frequency2[i]))
				frequency[i] = 0;
		}
		
		for (int i = 0; i < 50; i++)
		{
			System.out.println(i + "   " + frequency[i]);
		}
		
		
		
		int [][] sizes = new int[400][400];
		
		/* for (int h = 0; h < 400; h++)
			System.out.println("Row " + h);
			for (int j = 0; j < 400; j++)
			{
				try
				{
					sizes[j][h] = area(grid, j, h);
				} 
				catch (ProbablyInfiniteException e)
				{
					sizes[j][h] = 0;
				}
			}
		*/
		
		
		
		
		
		
		char sample[][] = new char[1200][1200];
		
		for (int i = 100; i < 1100; i++)
			for (int j = 100; j < 1100; j++)
				sample[i][j] = closestTo(points, i - 400, j - 400);
		
		
		
		
		
		
		
		
		int largest = 0;
		int num = 0;
		
		/* for (int h = 84; h < 400; h++)
		{
			
			for (int j = 0; j < 400; j+=1)
			{
				try
				{
					num = area(points, h, j, sample);
				}
				catch (Exception e)
				{
					num = 0;
					//System.out.println("Reporting area of infinity");
				}
				if (num > largest)
					largest = num; 
				if (num != 0)
					System.out.println("Reporting area of " + num);
			}
			//System.out.println("Largest as of row " + h + " is " + largest);
		} */
				
		//int largest = 0;
		
		
		for (Point p : points)
		{
			try
			{
				num = area(points, p.x(), p.y(), sample);
			}
			catch (Exception e)
			{
				num = 0;
			}
			catch (StackOverflowError e)
			{
				num = 0;
			}
			if (num > largest)
				largest = num;
			//System.out.println("Reporting got here");
			if (num != 0)
				System.out.println("Reporting area of " + num);
		}
				
		System.out.println(largest + "------------");
		
		//for (int h = 0; h < 400; h++)
		//{
		//	for (int j = 0; j < 400; j++)
		//		System.out.print(grid[j][h]);
		//	System.out.print('\n');
		//}
		
		
		
		
		
		int highestTotal = 0;
		
		
		System.out.println(totalDistance(points, 200, 2000));
		
		
		
		for (int j = -1700 ; j < 2100; j++)
			for (int k = -1700 ; k < 2100; k++)
				if (totalDistance(points, j, k) < 10000)
					highestTotal++;
		
		
		
		System.out.println(highestTotal);
		
		
		
		
		
		
		scan.close();
		//System.out.println(total);
		
		
		
	}
	
	
	public static int totalDistance(ArrayList<Point> points, int x, int y)
	{
		int total = 0;
		
		for (Point p : points)
			total += p.dist(x, y);
		return total;
	}
	
	public static int area(ArrayList<Point> points, int x, int y, char [][] proxGrid) throws ProbablyInfiniteException
	{
		
	
		LightInt frameNo = new LightInt(0);
		
		return recArea(proxGrid, points, x, y, closestTo(points, x, y), frameNo);
		
		
		
	}
	
	public static int recArea(char[][] gridMod, ArrayList<Point> points, int x, int y, char letter, LightInt frameNo) throws ProbablyInfiniteException
	{
		char myLetter = gridMod[x + 400][y + 400];
		frameNo.inc();
		//if (frameNo.get() > 5000)
		//{
		//	System.out.println("Frames Exceded  -  " + letter);
		//	throw new ProbablyInfiniteException();
		//}
		if (x < -100 || x >= 700 || y < -100 || y >= 700)
			throw new ProbablyInfiniteException();
		//if (gridMod[x + 400][y + 400] != letter)
		//	return 0;
		if (myLetter != letter)
			return 0;
		
		
		
		gridMod[x + 400][y + 400] = 'v';
		
		int ret = 1;
		
		ret	+= recArea(gridMod, points, x+1, y, myLetter, frameNo); 
		ret	+= recArea(gridMod, points, x-1, y, myLetter, frameNo); 
		ret	+= recArea(gridMod, points, x, y+1, myLetter, frameNo); 
		ret	+= recArea(gridMod, points, x, y-1, myLetter, frameNo);
		
		return ret;
	}
		
	public static char closestTo(ArrayList<Point> points, int x, int y)
	{
		
		int dist = 100000;
		int ii = 0;
		char ret = ' ';
		for (char i = 'A'; i < 'A' + 50; i++)
		{
			//System.out.println(i + " " + dist + " > " + points.get(ii).dist(j, h));
			if ( (points.get(ii).dist(x, y)) < dist)
			{
				//System.out.println("less");
				//System.out.println("Distance between point " + ii + " and " + h + ", " + j + " was " + points.get(ii).dist(j, h) + " and dist was " + dist);
				dist = points.get(ii).dist(x, y);
				//System.out.println(dist);
				ret = i;
			}
			//System.out.println("Distance between point " + ii + " and " + h + ", " + j + " was " + points.get(ii).dist(j, h));
			ii++;
		}
		ii = 0;
		for (char i = 'A'; i < 'A' + 50; i++)
		{
			//System.out.println(i + " " + dist + " > " + points.get(ii).dist(j, h));
			if ( (points.get(ii).dist(x, y)) == dist && i != ret)
			{
				return ' ';
			}
			//System.out.println("Distance between point " + ii + " and " + h + ", " + j + " was " + points.get(ii).dist(j, h));
			ii++;
		}
		
		return ret;
		
	}
	
	
	
}

class ProbablyInfiniteException extends Exception
{
	public ProbablyInfiniteException()
	{
		super();
	}
}

class LightInt
{
	int i;
	public LightInt(int i)
	{
		this.i = i;
	}
	public int get()
	{
		return i;
	}
	public void inc()
	{
		i++;
	}
}

class Point
{
	int x, y;
	public Point(int x, int y)
	{
		this.x = x; 
		this.y = y;
	}
	
	public int dist(Point p)
	{
		return Math.abs(x - p.x()) + Math.abs(y - p.y());
		
		
	}
	
	public int dist(int x, int y)
	{
		return Math.abs(x - this.x) + Math.abs(y - this.y);
		
		
	}
	
	public int x()
	{
		return x;
	}
	public int y()
	{
		return y;
	}
}