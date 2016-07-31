import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {

	
	public void calc() throws Exception
	{
		//BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String vals[] = br.readLine().split(" ");
		
		int []m = new int[n];
		int []r = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			m[i] = Integer.parseInt(vals[i]);
		}
		
		vals = br.readLine().split(" ");
		
		for (int i = 0; i < n; i++)
		{
			r[i] = Integer.parseInt(vals[i]);			
		}
		
		
		
		
		//for (int x = 1; x <=16; x++)
		//{
			//prct = 0;
		
		float res = 1.0f;
		
		int max = 1000000;
		/*
		for (int i = 0; i <n; i++)
		{
			
			int tmp = r[i] > m[i] ? r[i] : m[i];
			if (tmp > max)
				max = tmp;
		} */
		
		for (int j = 0; j <= max; j++)
		{
			boolean add = false;
		for (int i = 0; i < n; i++)
		{
			//int max = r[i] > m[i] ? r[i] : m[i];
		
			int prct = 0;
			int tot = 0;
			
				//max *= ((float)m[i])/ ((float) r[i]);
				
				if (j % m[i] == r[i])
					add = true;
				
				//tot ++;
			
			
			//float tmp = (((float)prct) / (max )); 
			//System.out.println(;
			//res /=  tmp;
		
		}
		
		if (add)
			res += 1;
		}
		
		res /= (max);
		
		
		
		
		System.out.println(res);
		
	}
	
	public static void main(String[] args) throws Exception{
		
		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
