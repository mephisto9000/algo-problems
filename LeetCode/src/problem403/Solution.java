package problem403;

class Solution {
    
    Map<Integer, Integer> sm;
    int[] stones;
    int last;
    Map<String, Boolean> memo;
    
    public boolean canCross(int[] stones) {
        this.stones = stones;
        
        sm = new HashMap();
        memo = new HashMap();
        for (int i = 0; i < stones.length; i++)
        {
            sm.put(stones[i], i);
            last = stones[i];
        }
        
        return rec(0,0);
    }
    
    boolean rec(int idx, int jump)
    {
        if (idx == last)
            return true;
        if (idx >= last)
            return false;
        
        if (!sm.containsKey(idx ))
             return false;

        String key = idx+" "+jump;
        if (memo.containsKey(key))
        	return memo.get(key);
        
        boolean ans = false;
        
        if (jump - 1 > 0 )
            ans = ans || rec(idx + jump-1, jump-1);
        
        ans = ans || rec(idx+jump+1, jump + 1);
        
        if (jump > 0)
            ans = ans || rec(idx+jump, jump);

        memo.put(key,  ans);
        return ans;
    }
}