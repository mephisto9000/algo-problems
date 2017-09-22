package problem34;



class Solution {
    public int[] searchRange(int[] nums, int target) {
        
    	int fck[] = {-1, -1};
    	
        if (nums==null || nums.length == 0)
            return fck;
        
        int n = nums.length - 1;
        
        if (binSearch(nums,0, n, target) == -1)  
 	
        	return fck;
        
        
        int lb = binSearch(nums,0, n, target - 1) ;
        
        if (lb == -1)
            lb = 0;
        
        int rb = binSearch(nums,0,n,target+1);
        if (rb == -1)
            rb = n;
        
        while(nums[lb]!=target)
            lb++;
        
        while(nums[rb]!=target)
            rb--;
        
        int[] ans = new int[2];
        ans[0] = lb;
        ans[1] = rb;
        
        return ans;
        
    }
    
    int binSearch(int[] nums, int l, int r, int v)
    {
        while(l < r)
        {
            int mid = (l + r ) /2;
            
            if (nums[mid] == v)
                return mid;
            
            if (nums[mid] < v)
                l = ++mid;
            else
                r = --mid;
        }
        
        if (nums[l] == v)
            return l;
        return -1;
    }
}