package problem448;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int n = nums.length;
        List<Integer> ans = new LinkedList();
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            
            if (v-1 != i)
                
            while(v-1 != i) {    
                 swap(nums, v-1, i);
                 int v_old = v;
                 v = nums[i];
                 if (v == v_old && v-1 != i) { 
                    break;
                }
            }
         }
        for (int i = 0; i < n; i++)
            if (nums[i]-1 != i)
                ans.add(i+1);
        
        return ans;
        
    }
    
    void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}