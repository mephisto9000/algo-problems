package problem35;

public class Solution {

	public static void main(String[] args) {
		
		
		Solution sol = new Solution();
		
		
		int[] arr = {1};
		int ans = sol.searchInsert(arr, 1);
		
		System.out.println(ans);

	}
	
	
	 public int searchInsert(int[] nums, int target) {
	        
	        int i = 0; 
	        int j = nums.length - 1;
	        
	        int mid = 0;
	        
	        int i1;
	        int j1;
	        while (i < j)
	        {
	        	
	        	i1 = i;
	        	j1 = j;
	        	
	        	
	        	 
	        	
	            mid = (j + i) / 2;
	            
	            if (nums[mid] < target)
	                i = mid;
	            
	            if (nums[mid] > target)
	                j = mid;
	            
	            if (nums[mid] == target)
	                return mid;
	            
	            if (i == i1 && j == j1)
	            	break;
	        }
	        
	        
	        
	        if (nums[i] < target)
        		i++;
	        
	        while(i < nums.length)
	        {
	        	if (nums[i] < target)
	        		i++;
	        	else
	        	{
	        		//if (i < nums.length && nums[i] > target)
	        		//	i --;
	        		break;
	        	}
	        
	        }
	        
	        
	        
	        if (i < 0)
	        	return 0;
	        
	        return i;
	        
	        
	    }

}
