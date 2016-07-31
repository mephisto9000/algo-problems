package problem1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Problem3 {
	
	
	public boolean isPerm(String a, String b)
	{
		HashMap<Character, Integer> h = new HashMap<Character, Integer>();
		
		char c;
		int val;
		
		if (a.length()!=b.length())
			return false;
				
		
		for (int i = 0; i < a.length(); i++)
		{
			c = a.charAt(i);
			
			if (h.containsKey(c))
			{
				val = h.get(c);
				h.put(c, ++val);
			}
			else
				h.put(c, 1);
		}
		
		for (int i = 0; i < b.length(); i++)
		{
			c = b.charAt(i);
			
			if (!h.containsKey(c))
				return false;
			
			val = h.get(c);
			
			if (val <= 0)
				return false;
			
			h.put(c, --val);
			
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Problem3 p = new Problem3();
		
		String a = br.readLine();
		String b = br.readLine();
		
		boolean isPerm = p.isPerm(a, b);
		
		if (isPerm)
			System.out.println("permutation");
		else
			System.out.println("not a permutation");
		
		/*
		 * example input
		 *  musaa
			musa
			not a permutation
			
			musa
			samu
			permutation						
		 */

	}

}
