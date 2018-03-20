package problem229;

import java.util.LinkedList;
import java.util.List;


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
         List<Integer> ans = new LinkedList();
        int target = (int) Math.floor(nums.length / 3.0f) + 1;
        
        
        
        int c1 = 1;
        int idx1 = 0;
        
        
        
        int c2 = 0;
        int idx2 = 0;
        
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] != nums[idx1])
            {
                idx2 = i;
                break;
            }
        }
        
        
        if (nums == null || nums.length == 0)
        {
            return ans;
        }
        
        if (nums.length == 1)
        {
            ans.add(nums[0]);
            return ans;
            
        }
        else
        if (nums.length > 1)
        {
                for (int i = 1; i < nums.length; i++)
                {
                	
                       
                       
                    if (nums[idx1] == nums[i])            
                        c1 ++;            
                    else
                    if (nums[idx2] == nums[i])
                        c2 ++;
                    else
                    	 if (c1 == 0 )
                         {
                             idx1 = i;
                             c1 = 1;
                         }
                    	 else
                    		  if (i >= idx2 && c2 == 0)
                              {
                                  idx2 = i;
                                  c2 = 1;
                              }	 
                    else
                    {
                        c1--;
                        c2 --;
                    }
                    
                    
                    if (c1 >= target)
                    	c1 +=100000;
                    
                    if (c2 >= target)
                    	c2 += 100000;

                    

             	  
                    
                  
                 
                    
                }
                
                
                     
        }
        
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == nums[idx1])
                cnt1 ++;
            
            if (nums[i] == nums[idx2] )
                cnt2 ++;
        }
        
        System.out.println(nums[idx1]);
        System.out.println(nums[idx2]);
        
      
        
        if (cnt1 >= target)
            ans.add(nums[idx1]);
        
        if (nums[idx2] != nums[idx1] && cnt2 >= target)
            ans.add(nums[idx2]);
                       
        return  ans;
        
        
        
        
    }
}