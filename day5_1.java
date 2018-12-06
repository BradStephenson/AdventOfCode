import java.util.*;
import java.io.*;

public class day5_1
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		
		//ArrayList<String> input = new ArrayList<String>();
		
		ArrayList<Character> letters = new ArrayList<Character>();
		
		String input = "";
		
		try
		{
			scan = new Scanner(new File("in5.txt"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		while(scan.hasNext())
		{
			input = scan.next();
		}
		int length = input.length();
		int length2 = length;
		
		for (int i = 0; i < length; i++)
		{
			letters.add(input.charAt(i));
			
		}
		boolean changed = true;
		
		ArrayList<Character> subLetters;
		
		Character characteru;
		Character characterl;
		
		for (char let = 'a'; let <= 'z'; let ++)
		{
			characterl = new Character(let);
			characteru = new Character(Character.toUpperCase(let));
			
			
			subLetters = new ArrayList<Character>();
			for (Character ch : letters)
				subLetters.add(ch);
			
			//remove
			
			while (subLetters.remove(characterl));
			while (subLetters.remove(characteru));
			
			System.out.println(let + " : " + react(subLetters));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		scan.close();
		//System.out.println(total);
		
		
		
	}
	
	
	public static int react(ArrayList<Character> letters)
	{
		boolean changed = true;
		
		int length = letters.size();
		int length2 = length;
		
		while (changed)
		{
			changed = false;
			for (int i = 0; i < letters.size() - 1; i++)
			{
				if (Character.toLowerCase(letters.get(i).charValue()) == Character.toLowerCase(letters.get(i + 1).charValue()) && !(letters.get(i).charValue() == letters.get(i + 1).charValue()))
				{
					letters.remove(i+1);
					letters.remove(i);
					changed = true;
					//System.out.println("Removed");
					length2 = length2 - 2;
				}
				
			}
		}
		
		
		//System.out.println(letters.size());
		
		
		
		
		
		
		//System.out.println(input);
		
		//System.out.println(length);
		
		//System.out.println(length2);
		
		return length2;
		
		
	}
	
	
}