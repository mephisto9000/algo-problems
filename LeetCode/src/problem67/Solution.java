package problem67;

public class Solution {

	public static void main(String[] args) {
		
		
		Solution sol = new Solution();
		
		String a = "1010";
		String b = "1011";
		
		
		String s = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		System.out.println(s.length());
		
		
		System.out.println(sol.addBinary(a, b));

	}


	public String addBinary(String a, String b) {

		long ai = strToBin(a);
		long bi = strToBin(b);
		
		

		return binToStr(ai + bi);


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
