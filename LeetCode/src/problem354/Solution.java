package problem354;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    
    class Doll implements Comparable
    {
        int w;
        int h;
        
        public Doll(int w, int h)
        {
            this.w = w;
            this.h = h;
        }
                
        @Override
        public int compareTo(Object o)
        {
            Doll d = (Doll) o;
            if (w > d.w)
            {
                return -1;
            }
            
            if (w < d.w)
            {
                return 1;
            }
            
            if (h > d.h)
            	return 1;
            
            if (h < d.h)
            	return -1;
            return 1;
        } 
    }
    
    
    List<Doll> dolls;
    int n;
    int memo[];
    int lis_max;
    public int maxEnvelopes(int[][] envelopes) {
        
        if (envelopes==null || envelopes.length == 0)
            return 0;
            
        n = envelopes.length;
        dolls = new ArrayList();
        
        
        for (int i = 0; i < n; i++)
        {
            Doll d = new Doll(envelopes[i][0], envelopes[i][1]);
            dolls.add(d);
        }
        
        Collections.sort(dolls);
        memo = new int[n];
        Arrays.fill(memo, -1);
        lis_max = 1;
                
        lis(n);
        
        return lis_max;                
    }
    
    int lis(int nn )
    {
        
        if (nn == 1)
            return 1;
        
        if (memo[nn-1]!=-1)
            return memo[nn-1];
        int max = 1;
        for (int i = 1; i < nn; i++)
        {
            int v = lis(i);
                         
             if (dolls.get(i-1).h > dolls.get(nn-1).h && v + 1 > max)
                max = v + 1;
        }
        
        if (max > lis_max)
            lis_max = max;
        
        memo[nn-1] = max;
        return max;
    }
    
    int triMax(int v1, int v2, int v3)
    {
        return Math.max(v1, Math.max(v2,v3));
    }
}
