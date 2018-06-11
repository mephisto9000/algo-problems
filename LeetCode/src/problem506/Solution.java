package problem506;

class Solution {
    
    PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
    Map<Integer, String> map = new HashMap();
    public String[] findRelativeRanks(int[] nums) {
        for (int i = 0; i < nums.length; i++) 
            pq.add(nums[i]);
        int z = 0;
        while( pq.size() > 0) {
            int v = pq.poll();
            if (z == 0)         
                map.put(v, "Gold Medal");  
            else
            if (z == 1)
                map.put(v, "Silver Medal");
            else
            if (z == 2)                
                map.put(v, "Bronze Medal");
            else
                map.put(v, Integer.toString(z+1));
            z++;
        }
        
        
        
        String[] ans = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            ans[i] = map.get(nums[i]);
                        
        return ans;
    }
}