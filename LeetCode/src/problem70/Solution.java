package problem70;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		Solution sol = new Solution();
		
		System.out.println(sol.climbStairs(1));

	}
	
	
	
	    
	    int memo[];
	    
	    int n;
	    
	    public int climbStairs(int n) {

	        memo = new int[n];  
	        
	        this.n = n;
	        
	        Arrays.fill(memo, -1);
	        
	        return rec(0);
	        
	    }
	    
	    int rec(int i)
	    {
	        if (i == n)
	            return 0;
	        
	        if (i == n - 1)
	        	return 1;
	        
	        if (i == n - 2)
	        	return 2;
	        
	        if (i > n)
	            return Integer.MIN_VALUE;
	        
	        if (memo[i] != -1)
	            return memo[i];
	        
	        int v1 = rec(i+1);
	        
	        int v2 = rec(i + 2);
	        
	        int ans = 0;
	        
	        if (v1 != Integer.MIN_VALUE)
	            ans += v1;
	        
	        if (v2 != Integer.MIN_VALUE)
	            ans += v2;
	        
	        memo[i] = ans;
	        
	        return ans;
	    }
	    
	    
	

}
