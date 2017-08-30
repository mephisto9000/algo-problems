package problem12;

import java.util.HashMap;
import java.util.Map;

public class Solution {
		
    
	public String intToRoman(int num) {
		Map tab = new HashMap();
		
		
		tab.put(1, "I");
		tab.put(4, "IV");
		tab.put(5, "V");
		tab.put(9, "IX");
		tab.put(10, "X");
		tab.put(40, "XL");
		tab.put(50, "L");
		tab.put(90, "XC");
		tab.put(100, "C");
		tab.put(400, "CD");
		tab.put(500, "D");
		tab.put(900, "CM");
		tab.put(1000, "M");
		
		int keys[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		int klen = 13;
						
		StringBuffer sb = new StringBuffer();
		
		while(num > 0)
		{
			for (int i = 0; i < klen; i++)
				if (num - keys[i] >= 0)
				{										
					sb.append(tab.get(keys[i]));
					num -= keys[i];
					
					break;
				}
			
			 
		}
				
		return sb.toString();        
    }
}
