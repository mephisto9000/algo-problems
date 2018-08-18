package problem681;


class Solution {
	
	List<Integer> keys = null;
	
    public String nextClosestTime(String time) {
        
        int nums[] = new int[4];
        nums[0] = (int) time.charAt(0)-'0';
        nums[1] = (int) time.charAt(1)-'0';
        nums[2] = (int) time.charAt(3)-'0';
        nums[3] = (int) time.charAt(4)-'0';
        
        int[] sortNums = nums.clone();
        
        
        Arrays.sort(sortNums);
        
        keys = new ArrayList();
        for (int i = 0; i < sortNums.length; i++)
        	keys.add(sortNums[i]);
                                        
        int curry = 1;
        for (int i = 3; i >= 0; i--) {
            if (curry == 1) {
                int idx = 0;
                 
                while(true) {
                	                 	                
                for (  idx = 0; idx < 4; idx++)
                    if (nums[i] == sortNums[idx])
                        break;
                
                int nextIdx = getNextIdx(nums[i]); 
                
                if (nextIdx < idx)
                    nums[i] = sortNums[0];
                else {
                    nums[i] = sortNums[nextIdx];
                    curry = 0;
                }
                                
                if (i >= 2) {
                
                if	((nums[2]*10 + nums[3]) <=59)
                    break;
                else
                	curry = 1; 
                }
                    
                if (i< 2) {
                if ((nums[0]*10 + nums[1]) <=23)                
                    break;
                else
                	curry = 1;
                }
            	}
                
            }
        }
        
        return nums[0]+""+nums[1]+":"+nums[2]+""+nums[3];        
        
        
    }
    
    int getNextIdx(int num) {
    	
    	int  idx = 0;
    	  for (; idx < 4; idx++)
              if (num == keys.get(idx))
                  break;
    	  
    	  int cnt = 0;
    	  while(true) {
    		  if (idx + 1 < keys.size() )
    			  idx ++;
    		  else
    			  idx = 0;
    		  
    		  if (num != keys.get(idx))
    			  break;
    		  
    		  cnt ++;
    		  if (cnt > keys.size())
    			  break;
    	  }
    	  
    	  return idx;
          
          
          }
    	
    
    
    
}