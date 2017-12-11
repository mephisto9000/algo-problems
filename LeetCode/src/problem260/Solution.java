package problem260;

class Solution {
    public int[] singleNumber(int[] nums) {
        
        Map<Integer, Integer> m = new HashMap();
        
        for (int i = 0; i < nums.length; i++)
        {
            if (m.containsKey(nums[i]))
            {
                int v = m.get(nums[i]);
                m.put(nums[i],++v);
            }
            else
            {
                m.put(nums[i],1);
            }
        }
        
        int []ans = new int[2];
        int c = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet())
        {
            //System.out.println(entry.getKey() + "/" + entry.getValue());
            if (entry.getValue() == 1)
            {
                ans[c] = entry.getKey();
                c++;    
            }
            
            if (c == 2)
                break;
        }
        
        return ans;
    }
}
