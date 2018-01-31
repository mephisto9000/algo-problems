package problem384;

class Solution {
    int nums[];
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        
        List<Integer> l = new LinkedList();
        
        for (Integer i : nums)
        {
            l.add(i);
        }
        
        Collections.shuffle(l);
        
        int ans[] = new int[l.size()];
        
        Iterator<Integer> it = l.iterator();
        
        int i = 0;
        while(it.hasNext())
        {
            ans[i++] = it.next();
        }
        
        return ans;
        
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
