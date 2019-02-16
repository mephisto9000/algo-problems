package problem137;

class Solution {
    public int singleNumber(int[] nums) {
        
        int cnt[] = new int[32];
        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            for (int i = 0; i < 32; i++) {
                int c = (num >> i) & 1;
                cnt[i] += c;
            }
        }
        
        int ans = 0;
        for (int i = 0; i < 32; i++)
            ans |= (cnt[i] % 3 == 0) ? 0: (1 << i);
        return ans;
    }
}