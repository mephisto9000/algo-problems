package problem303;

class NumArray {
    
    int preArray[];
    int postArray[];
    int totalSum;    

    public NumArray(int[] nums) {
        
        preArray = new int[nums.length];
        postArray = new int[nums.length];
        totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            if (i > 0)
                preArray[i] = preArray[i-1] + nums[i-1];            
        }
        
        for (int i = nums.length-2; i >= 0; i--)
            postArray[i] = postArray[i+1] + nums[i+1];
            
        
    }
    
    public int sumRange(int i, int j) {
        return totalSum - preArray[i] - postArray[j];        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */