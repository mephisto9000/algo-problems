package problem115;

class Solution {
    String s;
    String t;
    
    int[][] memo;
    
    public int numDistinct(String s, String t) {
        
        this.t = t;
        memo = new int[s.length()][t.length()];
        
        Set<Character> tset = new HashSet();
        for (int i = 0; i < t.length(); i++)
        {
            tset.add(t.charAt(i));
        }
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++)
            if (tset.contains(s.charAt(i)))
            {
                sb.append(s.charAt(i));                
            }
        s = sb.toString();
        
        this.s = s;
        
        for (int i = 0; i < s.length(); i++)
            Arrays.fill(memo[i], -1);
        return rec(0, 0);
        
    }
    
    int rec(int sidx, int tidx)
    {
                
        if (tidx >= t.length())
            return 1;
        
        if (sidx >= s.length() && tidx < t.length())
            return 0;
        
        if (memo[sidx][tidx] >= 0)
            return memo[sidx][tidx];
        int v = 0;
        if (s.charAt(sidx) == t.charAt(tidx))
            v = rec(sidx + 1, tidx + 1) + rec (sidx + 1, tidx);
        else
            v = rec(sidx + 1, tidx);
        
        memo[sidx][tidx] = v;
        return v;
        
    }
}