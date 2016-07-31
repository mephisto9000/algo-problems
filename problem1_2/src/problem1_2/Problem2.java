package problem1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 {

	
	public String reverse(String str)
	{
		if (str == null || str.isEmpty())
			return null;
		
		//String ret = "";
		StringBuffer sb = new StringBuffer();
		
		for (int i = str.length()-1; i >=0; i--)
		{
			sb.append(str.charAt(i));
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Problem2 p = new Problem2();
		
		String ret = p.reverse(br.readLine());
		System.out.println(ret);
	}

}
