package problem11;

class Solution {
    public int maxArea(int[] height) {
        
        
        int max = 0;
        
        
        int i = 0; 
        int j = height.length - 1;
        
        max = min(height[i], height[j]) * dist(i,j);
        
        while (i < j)
        {
        	int tmp = min(height[i], height[j]) * dist(i,j);
        	
        	if (tmp > max)
        		max = tmp;
        	
        	if (height[i] < height[j])
        		i++;
        	else
        		j --;
        }
        
        return max;
        
         
        
    }
    
    int dist(int a, int b)
    {
    	if (a > b)
    		return  a- b;
    	else
    		return b-a;
    }
    
    int min(int a, int b)
    {
    	if (a < b)
    		return a;
    	else
    		return b;
    }
}