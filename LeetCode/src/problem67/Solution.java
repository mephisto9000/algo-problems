package problem67;

public class Solution {

	public static void main(String[] args) {
		
		
		Solution sol = new Solution();
		
		String a = "1010";
		String b = "1011";
		
				
		System.out.println(sol.addBinary(a, b));

	}


	public String addBinary(String a, String b) {

		
		StringBuffer sb = new StringBuffer();
		
		int z = 0;
		
		int alen = a.length()-1;
		int blen = b.length()-1;
		
		int bit = 0;
		
		boolean stop = true;

		while(true)
		{
			int ai = 0;
			int bi = 0;
			
			stop = true;
			
			if (alen - z >= 0)
			{
				ai = a.charAt(alen - z) - '0';
				stop = false;
			}
			
			if (blen - z >= 0)
			{
				bi = b.charAt(blen - z) - '0';
				stop = false;
			}
			
			if (stop==true)
				break;
			
			
			z++;
			
			int v = (ai + bi) + bit;
			
			if ((v & 1) == 1)
				sb.insert(0, '1');
			else
				sb.insert(0, '0');
			
			
			if (v >= 2)
				bit = 1;
			else
				bit = 0;
							
			
		}
		
		if (bit == 1)
			sb.insert(0, '1');
				
		
		return sb.toString();


	}
	
	

	String binToStr(long v)
	{

		StringBuffer sb = new StringBuffer();
		while(v >0)
		{
			int x = (int) v & 1;
			v = v >> 1;

			if (x == 1)
				sb.insert(0, '1');
			else
				sb.insert(0,'0');
		}

		if (sb.length() == 0)
			sb.append("0");

		return sb.toString();
	}

	long strToBin(String a)
	{
		long ai = 0;
		
		for (int i = 0; i < a.length() ; i++)
		{
			char c = a.charAt(i);
			int ci = c - '0';

			ai = (ai << 1) + ci;
		}

		return ai;
	}




}
