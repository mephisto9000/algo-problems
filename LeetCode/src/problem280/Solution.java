package problem280;

class Solution {
    public void wiggleSort(int[] nums) {
                        
        int[] cpy = nums.clone();
        Arrays.sort(cpy);
        
        int i = 0; 
        int j = nums.length-1;
        int z = 0;
        int n = nums.length;
        while(i < j ) 
        {
            nums[z++] = cpy[i++];
            nums[z++] = cpy[j --];
        }
        
        if (n %2 != 0)
            nums[z] = cpy[i];
        
    }
}