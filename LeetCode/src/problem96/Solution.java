package problem96;

class Solution {
    
    Map<Integer, Integer> memo = new HashMap();
    
    public Solution() {
        memo.put(0,1);
        memo.put(1,1);
        memo.put(2,2);
    }
    public int numTrees(int n) {
            
        if (memo.containsKey(n))
            return memo.get(n);
 
        int ans = 0;
        for (int i = n-1; i >= 0; i--) {  
            ans += numTrees(i)*numTrees(n-i-1);
        }
        
        memo.put(n, ans);
        return ans;
    }
}