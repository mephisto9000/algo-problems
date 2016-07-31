package problem1_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4 {
	
	
	public String calc(String str, int arr_len, int len)
	{
		char[] cbuf = new char[arr_len];
		
		int z = 0;
		char c;
		
		for (int i = 0; i < len; i++)
		{
			c = str.charAt(i);
					
			if (str.charAt(i)!= ' ')
				cbuf[z++] = c;
			else
			{
				cbuf[z++] = '%';
				cbuf[z++] = '2';
				cbuf[z++] = '0';
			}
		}
		
		//assembling up the string
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr_len; i++)
		  sb.append(cbuf[i]);
		
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Problem4 p4 = new Problem4();
		
		String str = br.readLine();
		int int1 = Integer.parseInt(br.readLine());
		int int2 = Integer.parseInt(br.readLine());
		
		String ret = p4.calc(str, int1, int2);
		System.out.println(ret);
		
		/*
		 * sample input
		 	mr John Smith
			17
			13
			mr%20John%20Smith

		 */

	}

}
