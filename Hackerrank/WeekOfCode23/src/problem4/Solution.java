package problem4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {

	String src = null;
	
	public int calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		String s = br.readLine();
		
		long m = Long.parseLong(br.readLine());
		
		int res = 0;
		
		/*if (m > s.length())
		{
			return s.length();
		}*/
		
		StringBuffer front = new StringBuffer(s);
		StringBuffer back = new StringBuffer(s);
		
		int i = 0;
		int si = 0;
		while(i < m)
		{
			char c = s.charAt(si);
			front.append(c);
			back.insert(i, c);


			si++;
			
			if (si == s.length())
				si = 0;
			i++;
			
			if (front.toString().equals(back.toString()))
			{
				
				res++;
				break;
			}
		}
		
		//System.out.println(i);
		return ((int)(m / i) )% (1000000000 + 7);
	}
	
	
	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		System.out.println(sol.calc());


	}

}
