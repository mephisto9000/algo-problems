package problem152;


class Solution {
    public int maxProduct(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return 0;
        
        Integer max = Integer.MIN_VALUE;
        Integer lmax = Integer.MIN_VALUE;
        
        int i = 0;
        int j = 0;
        int n = nums.length;
        
        
        int n1[] =  new int[n];
        int n2[] =  new int[n];
        
        for (i = 0; i< n; i++)
        {
            n1[i] = nums[i];
            n2[i] = nums[i];                         
        }
        
        i = 0;
        while(i < n)
        {
            if (n1[i]  < 0)
            {
                j = i+1;
                
                boolean fnext = false;
                while(j < n)
                {
                    if (n1[j] == 0)
                        break;
                    
                    if (n1[j] < 0)
                    {
                        fnext = true;
                        break;
                    }
                    
                    j++;
                }
                
                if (fnext == true)
                {
                    n1[i] *= -1;
                    n1[j] *= -1;
                    
                    i = j;
                }
            }
            
            i++;
        }
        
        //for (i = 0; i < n; i++)
       // 	System.out.println(n1[i]);
        
        //System.out.println();
        
        
        i = n-1;
        while(i >= 0)
        {
            if (n2[i]  < 0)
            {
                j = i-1;
                
                boolean fnext = false;
                while(j >= 0)
                {
                    if (n2[j] == 0)
                        break;
                    
                    if (n2[j] < 0)
                    {
                        fnext = true;
                        break;
                    }
                    
                    j--;
                }
                
                if (fnext == true)
                {
                    n2[i] *= -1;
                    n2[j] *= -1;
                    
                    i = j;
                }
            }
            
            i--;
        }
        
        //for (i = 0; i < n; i++)
        //	System.out.println(n2[i]);
        
        
        
        for (  i = 0; i < nums.length; i++)
        {
            if (n1[i] <= 0)
            {
                lmax  = n1[i];
            }
            else
            {
                //if (lmax * nums)
                int v ;
                
                if (lmax == Integer.MIN_VALUE)
                    v = n1[i];
                else
                    v = lmax * n1[i];
                
                if (v > lmax)
                    lmax = v;
                else
                {
                	if (v!=0)
                		lmax = v;
                	else
                		lmax =  n1[i];
                }
            }
            
            if (max == Integer.MIN_VALUE || lmax > max)
                max = lmax;
        }
        
        
        //System.out.println(max);
        lmax = Integer.MIN_VALUE;
        for (  i = n-1; i >=0 ; i--)
        {
            if (n2[i] <= 0)
            {
                lmax  = n2[i];
            }
            else
            {
                //if (lmax * nums)
                int v ;
                
                if (lmax == Integer.MIN_VALUE)
                    v = n2[i];
                else
                    v = lmax * n2[i];
                
                if (v > lmax)
                    lmax = v;
                else
                {
                	if (v!=0)
                		lmax = v;
                	else
                		lmax =  n2[i];
                }
            }
            
            if (max == Integer.MIN_VALUE || lmax > max)
                max = lmax;
        }
         
       
        //System.out.println(max);
        
        
        
        return max;
        
    }
}