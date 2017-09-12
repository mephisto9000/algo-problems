package problem46;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
   public List<List<Integer>> permute(int[] nums) {
       
       Arrays.sort(nums);
       int n = nums.length ;
       
       List<List<Integer>> ans = new LinkedList<List<Integer>>();
       
       ans.add(toList(nums));       
       
       while(true)
       {
       	boolean done = true;
           for (int i = n-1; i > 0; i--)
           {
               if (nums[i-1] < nums[i])
               {
               	done = false;
                   
                   int vi = i;
                   for (int j = i; j< n; j++)
                   {
                       if (nums[j] > nums[i-1])
                       {
                           vi = j;
                       }
                   }
                   
                   swap(nums, i-1, vi);
                   rotate(nums, i, n-1);
                   
                   ans.add(toList(nums));                    
                   
                   break;
               }
           }
           
           if (done)
           	break;
       }
       
       return ans;
       
   }
   
   List<Integer> toList(int[] nums)
   {
   	List<Integer> l = new LinkedList<Integer>();
   	
   	for (int i = 0; i < nums.length; i++)
   		l.add(nums[i]);
   	return l;
   }
   
 
   void swap(int[] nums, int i, int j)
   {    	
       int t = nums[j];
       nums[j] = nums[i];
       nums[i] = t;
   }
   
   void rotate(int[] nums, int i, int j)
   {
       int tmp[] = new int[j-i+1];
       
       int tmpi = i;
       for (int x = 0; x < j-i+1; x++)
       {
           tmp[x] = nums[tmpi];
           tmpi++;
       }
       
       tmpi = i;
       for (int x = j-i; x>=0; x--)
       {
           //tmp[x] 
           nums[tmpi] = tmp[x];
           tmpi++;
       }
       
   }
   
   
}