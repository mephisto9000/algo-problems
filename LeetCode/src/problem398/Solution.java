package problem398;

class Solution {
    
    Map m;
    int n;
    public Solution(int[] nums) {
         m = new HashMap();
         if (nums == null || nums.length == 0)
            return;
         n = nums.length;
        for (int i = 0; i < n; i++)
        {
            if (!m.containsKey(nums[i]))
                m.put(nums[i], new HashSet());
            
            Set s = (Set) m.get(nums[i]);
            s.add(i);
        }
    }
    
    public int pick(int target) {        
        
        Set s = (Set) m.get(target);
        
        int maxIdx = s.size();
        int random = (int)(Math.random() * maxIdx );     
       
        List<Integer> list = new ArrayList(s);
        int ans = list.get(random);
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */