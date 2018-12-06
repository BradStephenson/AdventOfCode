import java.util.*;
import java.io.*;

public class day4_1
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> input = new ArrayList<String>();
		try
		{
			scan = new Scanner(new File("in4.txt"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		while(scan.hasNext())
		{
			input.add(scan.nextLine());
		}
		
		
		
		
		for (String s : input)
			System.out.println(s);
		
		Day shift;
		/* 
		for (String s : input)
			shift = new Day(s);;
		
		
		ArrayList[] guards = new ArrayList[10000];
		
		for (int i = 0; i < 10000; i++)
			guards[i] = new ArrayList<Day>();
		
		 */
		
		ArrayList<ShiftEvent> shiftEvents = new ArrayList<ShiftEvent>();
		
		
		for (String s : input)
			shiftEvents.add(new ShiftEvent(s));
		
		for (ShiftEvent s : shiftEvents)
			System.out.println(s.getStr());
		
		Collections.sort(shiftEvents);
		System.out.println("********************************************************************************");
		for (ShiftEvent s : shiftEvents)
			System.out.println(s.getStr());
		
		
		int[] times = new int[10000];
		
		int[][] minutes = new int[10000][60];
		
		int [] freqAsleep = new int[10000];
		
		
		int guard = 0;
		boolean start = true;
		
		ShiftEvent starter, ender;
		starter = new ShiftEvent();
		ender = new ShiftEvent();
		
		for (ShiftEvent s : shiftEvents)
		{
			if (s.getGuard() != -1)
				guard = s.getGuard();
			
			else
			{
				if (start)
				{
					starter = s;
					
					
					
					
				}
				else
				{
					ender = s;
				
					times[guard] += countMinutes(starter, ender);
					
					for (int j = starter.getMinute(); j < ender.getMinute(); j++)
						minutes[guard][j] ++;
					
					
					
					
					
					System.out.println("Guard " + guard + "  :   " + countMinutes(starter, ender));
				
				}
				start = !start;
			}
		}
		
		for (int j = 0; j < 10000; j++)
		{
			if (times[j] > 0)
				System.out.println("Guard " + j + " " + times[j]);
		}
		
		
		int highest = 0;
		for (int j = 0; j < 10000; j++)
		{
			if (times[j] > times[highest])
				highest = j;
		}
		
		for (int j = 0; j < 60; j++)
			System.out.println(j + ": " + minutes[highest][j]);
		
		System.out.println(highest + " x " + times[highest] + " = " + times[highest] * highest);
		
		
		int currHigh = 0;
		for (int j = 0; j < 10000; j++)
		{
			currHigh = 0;
			for (int h = 0; h < 60; h++)
				if (minutes[j][h] > currHigh)
				{
					currHigh = minutes[j][h];
					freqAsleep[j] = currHigh;
				}
					
		}
		
		int highest2 = 0;
		
		for (int j = 0; j < 10000; j++)
		{
			if (freqAsleep[j] > freqAsleep[highest2])
				highest2 = j;
		}
		
		System.out.println("Guard " + highest2 + "  " + freqAsleep[highest2]);
		
		for (int j = 0; j < 60; j++)
			System.out.println(j + ": " + minutes[highest2][j]);
		
		scan.close();
		//System.out.println(total);
		
		
		
	}
	
	public static Date getDateStatic(String date, Time t)
	{
		Date d;
		String[] datestuff = (date.substring(1)).split("-");
		
		int year = Integer.parseInt(datestuff[0]);
		int month = Integer.parseInt(datestuff[1]);
		int day = Integer.parseInt(datestuff[2].split(" ")[0]);
		
		System.out.print(year + " " + month + " " + day + "       " );
		
		d  = new Date(year, month, day, t.getHour(), t.getMinute());
		
		return d;
	}
	
	
	public static int countMinutes(ShiftEvent one, ShiftEvent two)
	{
		int ret = two.getDate().getMinutes() - one.getDate().getMinutes();
		
		if (ret < 0)
			ret += 60;
		
		return ret;
		
	}
	
}


class ShiftEvent implements Comparable<ShiftEvent>
{
	String str;
	Date date;
	
	boolean start = false;
	
	int guard = -1;
	
	public ShiftEvent(String in)
	{
		Time t  = new Time(in);
		date = day4_1.getDateStatic(in, t);
		str = in.substring(0);
		
		if (str.split(" ")[2].equals("Guard"))
		{
			start = true;
			guard = Integer.parseInt(str.split(" ")[3].substring(1));
		}
		
		
	}
	public ShiftEvent()
	{
	}
	
	public int getMinute()
	{
		return date.getMinutes();
	}
	
	public int getGuard()
	{
		return guard;
	}
	
	public String getStr()
	{
		return str;
	}
	
	public int compareTo(ShiftEvent s)
	{
		return date.compareTo(s.getDate());
	}
	
	public Date getDate()
	{
		return date;
	}
	
	
}






















class Time
{
	int hour, minute;
	boolean afterMidnight = false;
	public Time(String date)
	{
		String strdate = date.split(" ")[1];
		String strdate2[] = strdate.split(":");
		hour = Integer.parseInt(strdate2[0]);
		String strdate3 = strdate2[1].split("]")[0];
		minute = Integer.parseInt(strdate3);
		System.out.println(hour + " " + minute);
		
		if (hour == 0)
		{
		
			afterMidnight = true;
			
		}
	}
	public int getHour()
	{
		return hour;
	}
	public int getMinute()
	{
		return minute;
	}
	
	public boolean afterMid()
	{
		return afterMidnight;
	}
	
}