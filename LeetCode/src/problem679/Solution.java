package problem679;

class Solution {
    
    public boolean judgePoint24(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return false;
        
        List<Double> list = new ArrayList();
        
        for (int i = 0; i < nums.length; i++)
            list.add(new Double(nums[i]));
            
        return rec(list);                        
    }
    
    boolean rec(List<Double> list)
    {
       if (list.size() == 1)
           {if (Math.abs(24.0f - list.get(0) ) < 0.001f)
                return true;
            return false;
           }
                
        for (int i = 1; i < list.size(); i++)
        {
                          
            for (int j = 0; j < i; j++)
            {               
                Double f1 = list.get(i);
                Double f2 = list.get(j);
                                                                               
                if (helper(f1 + f2, list, i, j))
                    return true;
                
                if (helper(f1 - f2, list, i, j)) 
                    return true;
                
                if (helper(f2 - f1, list, i, j)) 
                    return true;
                
                if (helper(f1 * f2, list, i, j))
                    return true;
                
                if (helper(f1 / f2, list, i, j)) 
                    return  true;
                
                if (helper(f2 / f1, list, i, j)) 
                    return true;                                  
            }                       
        }
        
        return false;        
                                                
    }
    
    boolean helper(Double x, List<Double> list, int i, int j)
    {         
        
         List<Double> tl = new ArrayList();
         for (int z =0; z < list.size(); z++)
            if (z != i && z != j)
                tl.add(list.get(z));
        tl.add(x);
        
        return rec(tl);                               
    }
}