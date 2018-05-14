package problem525;

class Solution {
    
    
    public int findMaxLength(int[] nums) {
       
        
        if (nums == null || nums.length < 2)
            return 0;
        
        int tmp[] = new int[nums.length];
        if (nums[0] == 1)
            tmp[0] = 1;
        else
            tmp[0] = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] ==  1)
                tmp[i] = tmp[i-1]+1;
            else
                tmp[i] = tmp[i-1]-1;
        }
        
        int lidx=0;
        int max = 0;
        //for (int i = 0; i < nums.length; i++) {
        
       // int i = 0; 
        //int j = nums.length -1;
       

        for (int i = 0; i < nums.length; i++) {
        	if (nums[i])
        }
    	
        
        
        return max; //+1;
                    
    }
     
}