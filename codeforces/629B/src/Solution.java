import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		
		int n = Integer.parseInt(br.readLine());
		
		int f[] = new int[366];
		int m[] = new int[366];
		
		Arrays.fill(f, 0);
		Arrays.fill(m, 0);
		
		for (int i = 0; i < n; i++)
		{
			String vals[] = br.readLine().split(" ");
			
			char sex = vals[0].charAt(0);
			int from = Integer.parseInt(vals[1]);
			int to = Integer.parseInt(vals[2]);
			
			for (int z = from; z <= to; z++)
			{
				if (sex == 'F')
					f[z-1]++;
				else
					m[z-1]++;
			}
		}
		
		int max = 0;
		
		for (int i = 0; i < 366; i++)
		{
			int v = (f[i]<=m[i]) ? f[i] : m[i];
			
			if (v > max)
				max = v;
		}
		
		System.out.println(max * 2);
	}
	
	
	public static void main(String[] args) throws Exception{
		Solution sol = new Solution();
		sol.calc();

	}

}
