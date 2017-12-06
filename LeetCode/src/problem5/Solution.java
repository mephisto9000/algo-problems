package problem5;

class Solution {
    public String longestPalindrome(String s) {
        
        if (s == null || s.length() == 0)
            return null;
        
        int n = s.length();
        
        int max = 0;
        int max_i  = -1;
        int max_j = -1;
        
        
        for (int i = 0; i < n; i++)
        {
            int pi = i;
            int pj = i;
            int cnt = 0;
            while (pi >=0 && pj <= n-1 && s.charAt(pi) == s.charAt(pj))
            {
                int len = (pj - pi) + 1;
                
                if (len > max)
                {
                    max = len;
                    max_i = pi;
                    max_j = pj;
                }
                pi--;
                pj++;
                cnt ++;
            }
            
            pi = i;
            pj = i+1;
           // if (cnt == 1)
            while (pi >=0 && pj <= n-1 && s.charAt(pi) == s.charAt(pj))
            {
                int len = (pj - pi) + 1;
                
                if (len > max)
                {
                    max = len;
                    max_i = pi;
                    max_j = pj;
                }
                pi--;
                pj++;
            }
        }
        
        String ans = s.substring(max_i, max_j+1);
        return ans;                        
    }
}