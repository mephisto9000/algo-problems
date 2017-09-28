package interview1;

import java.util.Arrays;

public class Problem1 {
	
	int n;
	
	public int calc2(int[] nums)
	{
		if (nums == null || nums.length == 0)
			return 0;

		n = nums.length;
		int memo[] = new int[n];
	
		Arrays.fill(nums, 0);
		
		for (int i = n-1 ;i >=0; i--)
		{
			int v1 = nums[i];

			if (i + 2 < n)
				v1 += memo[i+2];
			
			int v2 = 0;

			if (i + 1 < n)
				v2 = memo[i+1];

			memo[i] = v1 > v2 ? v1:v2;
		}

		return memo[0];

	 }

	public int calc(int[] nums)
	{
			if (nums == null || nums.length == 0)
				return 0;

			n = nums.length;
		
			return	rec(nums, 0);

	}


	public int rec(int[] nums, int idx)
	{
		if (idx >= n)
			return 0;
		
		int v1 = nums[idx] + rec(nums, idx + 2);
		int v2 = rec(nums, idx + 1);
		
		return v1 > v2 ? v1 : v2;
	}


}
