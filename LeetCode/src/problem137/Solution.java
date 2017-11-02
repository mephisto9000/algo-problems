package problem137;

class Solution {
    public int singleNumber(int[] nums) {
        Map m = new LinkedHashMap();
        
        for (int i = 0; i < nums.length; i++)
        {
            if (!m.containsKey(nums[i]))
            {
                m.put(nums[i], 1);
            }
            else
            {
                int v = (Integer) m.get(nums[i]);
                v++;
                if (v == 3)
                    m.remove(nums[i]);
                else
                    m.put(nums[i], v);
            }
        }
        
        Set<Map.Entry> s = m.entrySet();
        int ans = (Integer) (s.iterator().next()).getKey();
        return ans;
        
    }
}