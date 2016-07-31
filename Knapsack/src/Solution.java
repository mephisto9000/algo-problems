
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	int[][] memo;
	int[] elements;
	int ans = 0;
	int maxSum = 0;
	
	//public void init()
	
	public int knapsack (int len, int[] elements, int sum)
	{		
		ans = 0;		
		memo = new int[len+1][sum+1];
		this.elements = new int[len]; 
		
				
		maxSum = sum;
		
		//initializing memoization part
		for (int i = 0; i < len; i++)
		{
			//memo[i] = -1;
			this.elements[i] = elements[i];
			
			for (int j = 0; j < sum; j++)
				memo[i+1][j+1] = -1;
		}
		
		
		
		return recSack(len, maxSum);
	}
	
	
	private int recSack(int len, int remainingSum)
	{
		
		//System.out.println("len == "+len + " sum == "+remainingSum);
		if (len == 0 || remainingSum == 0)
			return 0;
		
		
		if (remainingSum < 0)
			return Integer.MAX_VALUE;
		
		if (memo[len][remainingSum] != -1)
			return memo[len][remainingSum];
		
		//if (currentSum >= maxSum)
		//	return currentSum;
		
		int times = (int) (remainingSum / elements[len-1]);

		int r1 = times * elements[len-1] + recSack(len -1, remainingSum - times * elements[len-1]); //, currentSum + elements[len-1]);
		int r2 = recSack(len -1, remainingSum);

		// int tmp = recSack(len - 1, currentSum );

		int res = 0;
		
		//System.out.println("r1="+r1+" r2="+r2);
		
		if (r1 > r2 && r1 <= maxSum)
			res = r1;
		
		if (r2 >= r1 && r2 <= maxSum)
			res = r2;
		
		//memo[len-1] = res;
		
		/*
		if ((r + elements[len-1]) < maxSum)
			r = r + elements[len-1];
		*/
		
		
		//r = getMax(r, tmp);
		
		memo[len][remainingSum] = res;
		return res;
	}
	
	public int getMax(int a, int b)
	{
		if (a > b)
			return a;
		
		return b;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("test1.rtf"));
		
		int testCaseNum = Integer.parseInt(br.readLine());
		
		Solution sol = new Solution();
		
		for (int i = 0; i < testCaseNum; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Integer n = 0;
			Integer k = 0;
			int[] vals;
			
			while (st.hasMoreTokens())
			{
				 n = Integer.parseInt(st.nextToken()); //num of elements in array
				 k = Integer.parseInt(st.nextToken()); //expected sum																
			}
			
			st = new StringTokenizer(br.readLine());
			
			vals = new int[n];
			
			int j = 0;
			
			while (st.hasMoreTokens())
			{
				vals[j] = Integer.parseInt(st.nextToken());
				j++;
			}
			
			System.out.println(sol.knapsack(n, vals, k));
			
			
		}

	}

}
