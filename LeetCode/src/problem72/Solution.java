package problem72;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

class Solution {
	
	int lmin = 0;
    int lmax = 0;
    String strmin = null;
    String strmax = null;
    
    int[][] memo;
    
	public int minDistance(String word1, String word2) 
	{
		if (word1 == null || word1.length() == 0)
        {
            if (word2 != null && word2.length() != 0)
                return word2.length();
            else
                return 0;
        }
        
        if (word2 == null || word2.length() == 0)
        {
            if (word1 != null && word1.length() != 0)
                return word1.length();
        }
        
        int l1 = word1.length();
        int l2 = word2.length();
        
        
        
        strmin = null;
        strmax = null;
        
        lmin = 0;
        lmax = 0;
        
        if (word1.length() > word2.length())
        {
            strmin = word2;
            strmax = word1;
            lmin = l2;
            lmax = l1;
        }
        else
        {
            strmin = word1;
            strmax = word2;
            lmin = l1;
            lmax = l2;
        }
        
        memo = new int[lmax][lmax];
        
        for (int i = 0; i < lmax; i++)
        Arrays.fill(memo[i], -1);
        
        
        return dp(strmin, strmax, 0, 0);
		
		//return 0;
	}
	
	int dp(String s1, String s2, int idx1, int idx2)
	{
		
		if (idx1 >= lmin || idx2 >= lmax)
			return 10000;
		
		if (memo[idx1][idx2] != -1)
			return memo[idx1][idx2];
		
		if (idx1 == lmin-1 || idx2 == lmax-1)		
		{
 			int v;
			if (s1.charAt(idx1) == s2.charAt(idx2) )
				v =  Math.max(lmin - idx1 - 1, lmax  -idx2 - 1);
			else
			{
				int v1 =   Math.max(lmin - idx1 - 1, lmax  -idx2 - 1) + 1;
				int v2 = 1 +dp(s1,s2, idx1, idx2+1);
				int v3 = 1 + dp(s1,s2, idx1+1, idx2);
				
				  v = threeMin(  v1,   v2,   v3); 
				
				
			}
			
			memo[idx1][idx2] = v;
			return v;
			
			
			
		}
		 
		
		int v;
		if (s1.charAt(idx1) == s2.charAt(idx2) )
			v =  dp(s1,s2, idx1+1, idx2+1);
		else
		{
 			
			int v1 = 1 + dp(s1, s2, idx1+1, idx2);
			int v2 = 1 + dp(s1, s2, idx1, idx2+1);
			int v3 = 1 + dp(s1, s2, idx1+1, idx2+1);
			
			v = threeMin(  v1,   v2,   v3); 
			
			
		}
		
		memo[idx1][idx2] = v;
		return v;
		
		 
	}
	
	int threeMin(int v1, int v2, int v3)
	{
		int v;
		if (v1< v2) 
			v = v1;
		else
			v = v2;
		
		if (v3 < v)
			v = v3;
		return v;
	}
	
	 
}