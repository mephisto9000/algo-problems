package problem72;

class Solution {
    String str1;
    String str2;
    int memo[][];
    int memoLen = 1000;
    public int minDistance(String word1, String word2) {
          
        memoLen = Math.max(word1.length(), word2.length());
        
        memo = new int[memoLen][memoLen];
        for (int i = 0; i < memoLen; i++)
            Arrays.fill(memo[i], -1);
            
        
        return rec(0,0);
    }
    
    int rec(int idx1, int idx2) {
        if (idx1 == str1.length()) {
            if (idx2 == str2.length())
                return 0;
            else
                return str2.length() - idx2;
        }
        
        if (idx2 == str2.length())
            return str1.length() - idx1;
        
        if (memo[idx1][idx2]!=-1)
            return memo[idx1][idx2];
        
        char c1 = str1.charAt(idx1);
        char c2 = str2.charAt(idx2);
        
        int ans = 1000000;
        //equals, we don't do anything
        if (c1 == c2) 
            ans = Math.min(ans, rec(idx1+1, idx2+1));
        else {
            //del
            ans = Math.min(ans, 1+rec(idx1+1, idx2));
            
            //change
            ans = Math.min(ans, 1+rec(idx1+1, idx2+1));
            
            //ins
            ans = Math.min(ans, 1+rec(idx1, idx2+1));
        }
        
        memo[idx1][idx2] = ans;
        return ans;
    }
}