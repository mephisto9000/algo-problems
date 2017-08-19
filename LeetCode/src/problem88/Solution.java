package problem88;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Solution sol = new Solution();
		
		int[] a = {0,0};
		int al = 0;		
		int[] b = {1};
		int bl =1;
		sol.merge(a, al, b, bl);
		
		for (int i = 0; i < (al+bl); i++)
			System.out.print(a[i]+" ");
		
		
	}
	
	

	    public void merge(int[] nums1, int m, int[] nums2, int n) {
	        
	        
	        
	        
	        int offset = nums1.length - m - 1;
	        
	        int j = 1;
	        for (int i = m-1; i >=0; i--)
	        {
	            nums1[nums1.length - j ] = nums1[i];
	                
	            j++;
	        }
	        
	        int i = offset;
	        
	        int a = 0;
	        
	        j = 0;
	        
	        
	        while(i < (m+n) || j < n) //nums1.length
	        {
	            if (j>= n || (nums1[i]<nums2[j] && i< (m+n)))
	            {
	                nums1[a] = nums1[i];
	                i++;
	                a++;
	                
	            }
	            else
	            if (i >= nums1.length || (nums1[i] >= nums2[j] && j <n))
	            {
	                nums1[a] = nums2[j]; 
	                j++;
	                a++;
	            }    
	        }
	        
	        
	        
	        
	        
	    }
	

}
