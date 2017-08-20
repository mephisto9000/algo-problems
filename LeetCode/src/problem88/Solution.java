package problem88;

public class Solution {

	public static void main(String[] args) {
	}
	
	

	    public void merge(int[] nums1, int m, int[] nums2, int n) {
	    		    	
	    	int res[] = new int[n+m];
	    	
	    	int i = 0;
	    	int j = 0;
	    	int z = 0;
	    	
	    	boolean stop = false;
	    	while (i <= m && j <= n && stop == false)
	    	{
	    		stop = true;
	    		if (i < m && (j>= n || nums1[i] < nums2[j]))
	    		{
	    			res[z] = nums1[i];
	    			i++;
	    			z++;
	    			stop = false;
	    		}
	    		else
	    		if (j < n && (i >= m || nums1[i] >= nums2[j]))
	    		{
	    			res[z] = nums2[j];
	    			j++;
	    			z++;
	    			stop = false;
	    		}
	    	}
	    	
	    	
	    	for (i = 0; i < res.length; i++)
	    		nums1[i] = res[i];
	    	
	    	
	    }  	 	

}
