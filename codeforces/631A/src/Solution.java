import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		String vals[]  = s.split(" ");
		
		int ivals[] = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			ivals[i] = Integer.parseInt(vals[i]);
		}
		
		s = br.readLine();
		vals  = s.split(" ");
		
		int ivals1[] = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			ivals1[i] = Integer.parseInt(vals[i]);
		}
		
		int max = ivals[0];
		int max1 = ivals1[0];
		 
		
		for (int i = 1; i < n; i++)
		{
			max = max | ivals[i];
		}
		
		for (int i = 1; i < n; i++)
		{
			max1 = max1 | ivals1[i];
		}
		
		
		System.out.println(max + max1);
		
		
		
	}

	public static void main(String[] args) throws Exception {

		Solution sol = new Solution();
		sol.calc();


	}

}
