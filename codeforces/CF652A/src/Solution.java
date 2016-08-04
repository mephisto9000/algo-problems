import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {

	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input4.txt"));
		
		String[] vals = br.readLine().split(" ");
		
		int h1 = Integer.parseInt(vals[0]);
		int h2 = Integer.parseInt(vals[1]);
		
		vals = br.readLine().split(" ");
		
		int a = Integer.parseInt(vals[0]);
		int b = Integer.parseInt(vals[1]);
		
		h1-= a*4; 
		
		//System.out.println(h2-h1-a*12);
		//System.out.println(a*12-b*12);
		
		if (h2-h1-a*12 <=0)
			System.out.println(0);
		else
		if ((h2 - h1) > (a * 12) && (a*12) < (b*12))
			System.out.println(-1);
		else
		{
			if (a*12-b*12 == 0)
				System.out.println(-1);
			else
			//System.out.println(((h2-h1-a*12)/(a*12-b*12)) + 1);
			{
				
				int height = h1;
				int days = 0;
				while(true)
				{
					//h1 + a*12
					height += a*12;
					if (height >= h2)
						break;
					
					height -= b*12;
					days++;
				}
				
				System.out.println(days);
			}
				
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception{
	
		Solution sol = new Solution();
		sol.calc();
			

	}

}
