package problem516;

class Solution {
    int max = 0;
    String str;
    String revStr;
    int memo[][];
    
    public int longestPalindromeSubseq(String s) {
        str = s;
         StringBuilder input1 = new StringBuilder(); 
        // append a string into StringBuilder input1
        input1.append(s); 
        // reverse StringBuilder input1
        input1 = input1.reverse();
        revStr = input1.toString();
        memo = new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++)
            Arrays.fill(memo[i], -1);
        
        return rec(str.length()-1, revStr.length()-1);
        
        
    }
    
    int rec(int idx, int revIdx ) {
        if (idx < 0 || revIdx < 0 )
            return 0;
        
        if (memo[idx][revIdx] >= 0)
            return memo[idx][revIdx];
        
        int ans = 0;
        if (str.charAt(idx) == revStr.charAt(revIdx)) {
            ans = 1 + rec(idx-1, revIdx-1);
        }
        else
            ans = Math.max(rec(idx-1, revIdx), rec(idx, revIdx-1));
        
        
        memo[idx][revIdx] = ans;
        return ans;
        
    }
    
     
}