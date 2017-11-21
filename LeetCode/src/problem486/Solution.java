package problem486;

class Solution {
    
    long sum[];
    int n;
    int nums[];
    
    public boolean PredictTheWinner(int[] nums) {
        
        if (nums == null || nums.length <= 1)
            return true;
        
        n = nums.length;
        this.nums = nums;
        sum = new long[2];      
        
        
        Arrays.fill(sum, 0);
        return rec(0, 0, n-1);
    }
    
    int altPlayer(int player)
    {
        return player == 0 ? 1 : 0;  
    }
    boolean rec(int player, int startIdx, int endIdx)
    {
        if (startIdx ==  endIdx)
        {
            sum[player] += nums[startIdx];
            
            boolean ans = false;
            if (sum[0] >= sum[1])
                ans =  true;
            else
                ans = false;    
            sum[player] -=  nums[startIdx];
            return ans;
        }
        
        sum[player] += nums[startIdx];
        
        boolean ans1 = rec(altPlayer(player), startIdx + 1, endIdx);
        sum[player] -= nums[startIdx];
                
        sum[player] += nums[endIdx];
        boolean ans2 = rec(altPlayer(player), startIdx, endIdx - 1);
        sum[player] -= nums[endIdx];
        
        if (player == 0 && (ans1==true || ans2 == true))
        	return true;
        
        
        if (ans1 == ans2 && ans1 == true)
        return true;
        else
        return false;
    }
    
}