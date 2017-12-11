package problem97;

class Solution {
    String s1;
    int s1l;
    String s2;
    int s2l;
    String s3;
    int s3l;
    int memo[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if (s3.length() != s1.length() + s2.length())
            return false;       
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
                        
        s1l = s1.length();
        s2l = s2.length();
        s3l = s3.length();
        
        if (s1l==0 )
            if (s2.equals(s3))
                return true;
            else
                return false;
      
        if (s2l == 0)
            if (s1.equals(s3))
                return true;
            else
                return false;        
        
        memo = new int[s1l+1][s2l+1];
        
        for (int i = 0; i <= s1l; i++)
            for (int j = 0; j <= s2l; j++)
                memo[i][j] = -1;
        
        return (rec(0,0) == 0  ? true : false);
    }
    
    int rec(int idx1, int idx2)
    {
        if (idx1 >= s1l && idx2 >= s2l)
            return 0;         
        
        if (memo[idx1][idx2] != -1)
            return memo[idx1][idx2];
        
        int v1 = 1;
        int v2 = 1;
        
        if (idx1 < s1l)
        {
        if (s1.charAt(idx1) == s3.charAt(idx1 + idx2))
            v1 = rec(idx1+1, idx2);
        
        if (v1 == 0)
        {
            memo[idx1][idx2] = 0;
            return 0;
        }
        }
        
        if (idx2 < s2l)
        {
        if (s2.charAt(idx2) == s3.charAt(idx1 + idx2))
            v2 = rec(idx1, idx2 + 1);
        
        if (v2 == 0)
        {
            memo[idx1][idx2] = 0;
            return 0;
        }
        }
        
        memo[idx1][idx2] = 1;
        return 1;
        
         
    }
    
    
}