package problem1_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5 {

	/**
	 * running time is O(n)
	 * @param str
	 * @return
	 */
	public String zip(String str)
	{
		char c = '0';
		int cnt = 0;
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < str.length(); i++)
		{
			if (c!=str.charAt(i) && c!='0')
			{
				sb.append(c);
				sb.append(cnt);
				cnt = 0;
			}
			
			c = str.charAt(i);
			cnt ++;
			
			if (i == str.length()-1)
			{
				sb.append(c);
				sb.append(cnt);
			}
			
		}
		
		if (sb.length() < str.length())
			return sb.toString();
		else
			return str;
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Problem5 p = new Problem5();
		
		String input = br.readLine();
		
		String zipped = p.zip(input);
						
		System.out.println(zipped);
		
		/*
		 *  sample input: 
		    aabcccccaaa
			a2b1c5a3

			abc
			abc
		 */
		
	}

}
