import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class Solution {

	public void calc() throws Throwable
	{
		BufferedReader br = new BufferedReader(new FileReader("road.in"));
		
		int w = Integer.parseInt(br.readLine());
		
		String[] s = new String[2]; 
		
		s[0] = br.readLine();
		s[1] = br.readLine();
		
		int px = 0;
		int py = 0;
		
		boolean result = true;
		
		for (int i = 0; i < w; i++)
		{
			if ((s[0].charAt(i)=='W') && (s[1].charAt(i)=='W'))
			{
				result = false;
				break;
			}
		}
		
		if (s[0].charAt(0) == 'W' || s[0].charAt(w-1)=='W')
			result = false;
		

		
		PrintWriter writer = new PrintWriter("road.out");
		
		
		if (result)
			writer.println("YES");
		else
			writer.println("NO");
		writer.close(); 
		
		/*
		if (result)
			System.out.println("YES");
		else
			System.out.println("NO"); */ 
		
	}
	
	
	public static void main(String[] args) throws Throwable{
		Solution sol = new Solution();
		
		sol.calc();

	}

}