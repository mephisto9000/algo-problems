package problem13;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	
	
	

	public static void main(String[] args) {

		Solution sol = new Solution();
		
		//int ans = sol.romanToInt("MCMXCVI");
		int ans = sol.romanToInt("MMMCXXXIX");
		
		System.out.println(ans);
	}
	
	public int romanToInt(String s) {
		Map tab = new HashMap();
		
		tab.put("I", 1);
		tab.put("IV", 4);
		tab.put("V", 5);
		tab.put("IX", 9);
		tab.put("X", 10);
		tab.put("XL", 40);
		tab.put("L", 50);
		tab.put("XC", 90);
		tab.put("C", 100);
		tab.put("CD", 400);
		tab.put("D", 500);
		tab.put("CM", 900);
		tab.put("M", 1000);
		
		int ans = 0;
		
		int i = 0;
		
		while(i < s.length())
		{
			int v1 = (int) tab.get(String.valueOf(s.charAt(i)));
			
			int v2 = 0;
			if (i < s.length()-1 && tab.containsKey(s.substring(i, i+2)))
			{
				v2 = (int)tab.get(s.substring(i, i+2));
				
				
			}
			
			if (v1 >= v2)
			{
				ans += v1;
				
				 
				i++;
			}
			else
			{
				ans += v2;
				
				 
				i+=2;
			}
		}
		
		
		return ans;        
    }

}
