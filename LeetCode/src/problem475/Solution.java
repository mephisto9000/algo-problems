package problem475;

class Solution {
          
    public int findRadius(int[] houses, int[] heaters) {
         
       int max = 0; 
       Arrays.sort(heaters);
       for (int i = 0; i < houses.length; i++) {
           max = Math.max(binSearch(heaters, houses[i]), max);
       }        
       return max;
    }
    
    int binSearch(int nums[], int v) {
        int i = 0; 
        int j = nums.length-1;
        
        while(i <= j) {
            int m = (i+j)/2;
            
            int x = nums[m];
            
            if (x == v)
                return 0;
            
            if (x > v)
                j = m-1;
            else
                i = m+1;
                
        }
        
        
        int l = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        if (i -1 >= 0)
            l = v - nums[i-1];
        
        if (i < nums.length)
            r = nums[i] - v;
        return Math.min(l,r);
    }
}