package problem658;


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int i = 0;
        int j = arr.length- k ;
        int m = 0;
        
        while(i < j)
        {
            m = (i + j)/2;
            
            if (Math.abs(arr[m] - x) > Math.abs(arr[m+k] - x) )
                i = m+1; 
            else
            	j = m ;               
        }
         
        List<Integer> l = new LinkedList();
        
        for (int a = i; a < i+k; a++)
        	l.add(arr[a]);
        return l;
        
    }
}