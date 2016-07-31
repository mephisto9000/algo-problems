import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++)
		{
			int v = Integer.parseInt(br.readLine());
			
			if (v % 2 == 0)
				System.out.println(v+ " is even");
			else
				System.out.println(v+ " is odd");
		}
	}

	public static void main(String[] args) throws Exception {

		Solution sol = new Solution();
		
		sol.calc();

	}

}
