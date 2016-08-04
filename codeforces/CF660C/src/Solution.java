import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {

	int[] arr;
	int n;
	int k;
	
	int maxVal = 0;
	int maxResult = 0;
	
	public void calc() throws Exception
	{
		
		//BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		//System.out.println("here");
		String vars[]  = br.readLine().split(" ");
		
		 n = Integer.parseInt(vars[0]);
		 k = Integer.parseInt(vars[1]);
		
		arr = new int[n];
		
		vars = br.readLine().split(" ");
		
		for (int i = 0; i < n; i++)
		{
			arr[i] = Integer.parseInt(vars[i]);
		}
		
		rec(0, 0, 0, 0);
		
		
		StringBuffer sb = new StringBuffer();
		
		//for (int i = 0; i < maxVal)
		
		/*if (maxVal == 0)
			for (int i = 0; i < n; i++)
			{
			sb.append("0");
			sb.append(' ');
			}
			*/	
		
		//while(maxVal > 0)
		System.out.println(maxResult);
		
		for (int i = 0; i < n; i++)
		{
			sb.insert(0, maxVal & 1);
			sb.insert(0, ' ');
			
			
			maxVal = maxVal >> 1;
		}
		System.out.println(sb.toString().trim());
		
		
	}
	
	public int rec(int idx, int sum,  int k_used, int val)
	{
		
		//System.out.println(arr[idx]);
		
		
		//System.out.println(sum + " "+val);
		
		
		if (sum >= maxResult)  // &&
		{
			maxResult = sum;
			
			
			 if (val >= maxVal)
			 {
				 maxVal = val;
				 
				 for (int j = idx; j < n; j++)
				 {
					 maxVal = maxVal << 1;
					 
					 if (arr[j] == 1)
						 maxVal += 1;
				 }
				 
			 }
		}
		
		
		/*
		if (sum > localSumm)
		{
			localSumm = sum;
			
			
		}*/
		 
		
		
		
		
		
		if (idx >= n)
		{
			
			
			return sum;
		}
		
		val = val << 1;
		
		
		if (arr[idx]==1)
		{
			sum ++;
			 
			val+=1;
		}
		
		
		
		 
		
		int v1 = sum;
		int v2 = sum;
		
		if (arr[idx]==0)
		{
			if (k_used < k)
				v2 = max(rec(idx+1, sum+1, k_used+1, val+1) , rec(idx+1, 0, k_used, val));			
			else
			{
				
				v1 = rec(idx+1, 0, k_used, val);
				v2 = 0;
			}
		}
		else
		{
			v1 = rec(idx+1, sum, k_used, val);
		}
		
		
		
		return max(v1, v2);
	}
	
	int max(int a, int b)
	{
		return a>b?a:b;
	}
	
	

	public static void main(String[] args) throws Exception{

		
	Solution sol = new Solution();
	
	sol.calc();

	}

}
