package Problem4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	String src = null;
	int off = 'A' - 'a';
	int lenA ;
	int lenB ;
	
	public String calc() throws Exception
	{
		BufferedReader br;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++)
		{
			String a = br.readLine()+' ';
			String b = br.readLine()+' ';
			
			lenA = a.length();
			lenB = b.length();
			
			boolean ans = rec(a,0,b,0, 0);
			
			if (sb.length() > 0)
				sb.append("\n");
			
			sb.append(ans == true ? "YES" : "NO");
		}
		
		
		return sb.toString();
	}
	
	public boolean rec(String a, int a_idx, String b, int b_idx, int matched)
	{
		//if(a_idx >= lenA && b_idx >= lenB)
		//if (lenB <= b_idx && lenA <= a_idx)
		//	return true;
		if (a_idx >= lenA)
		{
			if (matched == lenB)
				return true;
			else
				return false;
		}
		
		//if (lenB <= b_idx && lenA > a_idx)
		//	return false;
		
		if (a_idx >= lenA && b_idx < lenB)
			return false;
		
		if(b.charAt(b_idx) == a.charAt(a_idx))
		{
			return rec(a, a_idx+1, b, b_idx+1, matched +1);
		}
		
		boolean ans = false;
		
		if (b.charAt(b_idx) == a.charAt(a_idx)+off)
		{
			ans =   rec(a, a_idx+1, b, b_idx+1, matched +1);
		}
		
		if (Character.isUpperCase(a.charAt(a_idx)))
			return false;
		
		if (ans ==false)
		{
			ans =   rec(a, a_idx+1, b, b_idx, matched );
		}
		
		
		return ans;
		
	}

	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		System.out.println(sol.calc());

	}

}
