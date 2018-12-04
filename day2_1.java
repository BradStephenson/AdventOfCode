import java.util.*;
import java.io.*;

public class day2_1
{
	public static void main(String args[])
	{
		Scanner scan;
		int freq[];
		int threes = 0;
		int twos = 0;
		scan = new Scanner(System.in);
		try
		{
			scan = new Scanner(new File("in2.txt"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}	
			
		while(scan.hasNext())
		{
			freq = frequ(scan.next());
			printArray(freq);
			twos += countTwos(freq);
			threes += countThrees(freq);
		}
		System.out.println(twos*threes);
		
		scan.close();
			
			
		
		
	}
	
	public static void printArray(int[] ar)
	{
		System.out.print("[ ");
		for (int i = 0; i < ar.length; i++)
		{
			System.out.print(ar[i] + " ");
		}
		System.out.println("]");
	}
	
	public static int countTwos(int[] freq)
	{
		for (int i = 1; i < 27; i++)
		{
			if (freq[i] == 2)
				return 1;
		}
		return 0;
	}
	
	public static int countThrees(int[] freq)
	{
		for (int i = 1; i < 27; i++)
		{
			if (freq[i] == 3)
				return 1;
		}
		return 0;
	}
	
	public static int[] frequ(String in)
	{
		int[] freq = new int[27];
		Scanner strscan = new Scanner(in);
		for (int i = 0; i < 26; i++)
		{
			freq[letter(in.charAt(i))]++;
			System.out.println(in.charAt(i) + " " + letter(in.charAt(i)));
		}
		return freq;
	}
	
	public static int letter(char in)
	{
		if (in == 'a') return 1;
		if (in == 'b') return 2;
		if (in == 'c') return 3;
		if (in == 'd') return 4;
		if (in == 'e') return 5;
		if (in == 'f') return 6;
		if (in == 'g') return 7;
		if (in == 'h') return 8;
		if (in == 'i') return 9;
		if (in == 'j') return 10;
		if (in == 'k') return 11;
		if (in == 'l') return 12;
		if (in == 'm') return 13;
		if (in == 'n') return 14;
		if (in == 'o') return 15;
		if (in == 'p') return 16;
		if (in == 'q') return 17;
		if (in == 'r') return 18;
		if (in == 's') return 19;
		if (in == 't') return 20;
		if (in == 'u') return 21;
		if (in == 'v') return 22;
		if (in == 'w') return 23;
		if (in == 'x') return 24;
		if (in == 'y') return 25;
		if (in == 'z') return 26;
		return 0;
	}
	
	
}