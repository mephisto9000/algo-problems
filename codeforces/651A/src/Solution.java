import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] vals = br.readLine().split(" ");
		
		int a1 = Integer.parseInt(vals[0]);
		int a2 = Integer.parseInt(vals[1]);
		
		int time = 0;
		while(a1 >0  && a2 > 0)
		{
			if ( a1 > a2)
			{
				a1-=2;
				a2 ++;
			}
			else
			{
				a2-=2;
				a1++;
			}
			
			if (a1 >=0  && a2 >= 0)
				time++;
		}
		
		System.out.println(time);
				
	}

	public static void main(String[] args) throws Exception {
		
		Solution sol = new Solution();
		
		sol.calc();
		

	}

}
