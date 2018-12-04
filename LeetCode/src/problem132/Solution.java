package problem132;

class Solution {
    
    String s;
    int memo[][];
    
    public int minCut(String s) {
        this.s = s;
        memo = new int[s.length()+1][s.length()+1];
        return rec(0, s.length()-1);
    }
    
    
    int rec (int startIdx, int endIdx) {
        if (endIdx - startIdx <= 0 || isPal(s.substring(startIdx, endIdx+1))) //endIdx - startIdx <= 1 || 
            return 0;
        
        if (memo[startIdx][endIdx]> 0)
            return memo[startIdx][endIdx];
        
        int ans = Integer.MAX_VALUE;
        for (int i = startIdx+1; i <= endIdx; i++) {
            String x = s.substring(i, endIdx+1);
            if (isPal(x)) {
                ans = Math.min(1+rec(startIdx, i-1), ans);
            }
            
        }
        
        memo[startIdx][endIdx] = ans;
        return ans;
    }
    
    boolean isPal(String str) {
        int i = 0; 
        int j = str.length()-1;
        while(i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false; 
        }
        return true;
    }
}