package problem15;

class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new LinkedList();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; i++) {
            int l = i+1;
            int h = nums.length-1;
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            while(l < h ) {
                int s = nums[l] + nums[h];
                if (s == -nums[i]) {
                    ans.add(new LinkedList(Arrays.asList(nums[i],nums[l],nums[h])));
                   while (l+1 <= h && nums[l]==nums[l+1])
                        l++;
                    l++;
                    while(h-1 >= l && nums[h]==nums[h-1])
                        h--;
                    h--;
                }
                else {
                    if (s < -nums[i]) {
                        l++;
                    }
                    else {
                        h--;
                    }
                }
            }
            
        }
        
        return ans;
        
    }
}