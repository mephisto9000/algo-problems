package problem26;
public class Solution {
    public int removeDuplicates(int[] nums) {
		 
		 int len = nums.length;
		 int i = 0;
		 int v = 0;
		 while(i < nums.length-1)		 
		 {
			 if (nums[i]==nums[i+1])
			 {				 
				 int z = i+1;
				 while(z<nums.length)
				 {
					 if (nums[i]==nums[z])
					 {
						 len--;
					 	z++;
					 }
					 else
					 {
						 i = z;
						 break;
						 
					 }
					 
					 
				 }
				 i = z;
				 continue;
			 }
			 
			 nums[v]= nums[i];
			 i++;			 
			 v++;
		 }
	       
		 
		 return len;
	 }
}