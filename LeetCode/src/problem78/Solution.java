package problem78;



class Solution {
   
   Set<String> cache;
   List<List<Integer>> ans;
   
   public List<List<Integer>> subsets(int[] nums) {
       
       cache = new HashSet<String>();
       
       ans = new LinkedList<List<Integer>>();
   
       rec(nums, 0, "");
       
       return ans;
   }
   
   void rec(int[] nums, int idx, String pref )
   {
   	   	   	             
       if (!cache.contains(pref))
       {
           ans.add(strToList(pref));
           cache.add(pref);
       }
       if(idx >= nums.length)
           return;
       
     
       
       rec(nums, idx + 1, pref);
       rec(nums, idx + 1, pref +','+ nums[idx] );
       
   }
   
   List<Integer> strToList(String str)
   {
   	   	
       List<Integer> l = new LinkedList<Integer>();
            
       
       String vals [] = str.split(",");
       
       
       for (int i = 0; i < vals.length; i++)
       {
       	
       	try
       	{
       	l.add(Integer.parseInt(vals[i]));
       	}
       	catch(Exception e)
       	{
       		
       	}
       }
        
       
       return l;
   }
}