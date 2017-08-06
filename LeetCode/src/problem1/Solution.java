package problem1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {

		
		Solution sol = new Solution();
		
		int a[] = {3,2,4};
		
		int ans[] = sol.twoSum(a, 6);
		
		for (int i = 0; i < ans.length; i++)
		{
			System.out.print(ans[i]+" ");
		}

	}
			
	public int[] twoSum(int[] nums, int target) {
		
		Map m = new HashMap();
		
		int[] ans = new int[2];
		
		int i = 0;
		for (int val: nums)
		{
			m.put(val, i);
			
			
				
			i++;
		}
		
		for (  i = 0; i < nums.length; i++)
		{
			if (m.containsKey(target - nums[i]) )
			{
												
				int v = (Integer) m.get(target-nums[i]);
				
				if (nums[v] + nums[i] == target && v != i)
				{
					ans[0] = i;
					ans[1] = v;
				
					return ans;
				}
			}
		}
		
		
		return ans;
	        
	}
	

}
