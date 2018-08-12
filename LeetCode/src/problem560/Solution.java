package problem560;

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap();
        int sum = 0;
        int ans = 0;
        
        map.put(0,1);
       
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (map.containsKey(sum-k))
                ans+=map.get(sum-k);
            map.put(sum, map.getOrDefault(sum,0)+1);
            
        }
        
        return ans;
        
    }
}




Collapse 
9:28 PM
