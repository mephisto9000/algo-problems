package problem167;


class Solution {
   public int[] twoSum(int[] numbers, int target) {
       
       for (int i = 0; i < numbers.length; i++)
       {
           int v1 = numbers[i] ;
           
           int v2 = target - v1;
           
           int idx = binSearch(numbers, 0, numbers.length-1, v2);
           
           if (idx < 0)
           	continue;
           
           if (idx == i)
           	idx++;
            int[] ans = new int[2];
           if (idx >=0)
           {
              
               
               if (i < idx)
               {
                   ans[0] = i+1;
                   ans[1] = idx+1;
               }
               else
               {
                   ans[1] = i+1;
                   ans[0] = idx+1;
               }
           }
           
           return ans;
       }
       
       return null;
       
   }
   
   int binSearch(int[] nums, int start, int end, int v)
   {
       
       while(start < end)
       {
           int mid = (end + start) / 2;      
       
           if (nums[mid] == v)
           {
               start = mid;
               break;
           }
       
           if (nums[mid] < v)
                start = mid+1; //binSearch(nums, mid+1, end);
           else
               end = mid - 1;
       }
       
       if (nums[start] == v)
           return start;
       return -1;
       
       
   }
}
