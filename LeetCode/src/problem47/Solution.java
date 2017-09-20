package problem47;



class Solution {
   public List<List<Integer>> permuteUnique(int[] nums) {
       
       if (nums == null)
           return null;
       int n = nums.length;
       
       if (n == 0)
           return null;
       
       List ans = new LinkedList();
       Set preAns = new HashSet();
       
       Arrays.sort(nums);
       savePerm(nums, preAns);
      
       while(true)
       {
           boolean stop = true;
           for (int i = n-1; i > 0; i--)   
           {
               if (nums[i] > nums[i-1])
               {
                   int m = i;
                   for (int j = i; j < n; j++)
                   {
                       if (nums[j] > nums[i-1])
                           m = j;
                   }
                   
                   swap(nums, i-1, m);
                   rotate(nums, i, n-1);
                   savePerm(nums, preAns);
                   
                   stop = false;
                   break;
               }
           }
           if (stop)
           	break;
       }
       
       Iterator it = preAns.iterator();
       
       
       while(it.hasNext())
       {
           String s = (String) it.next();
           String[] vals = s.split("_");
           
           List l = new LinkedList();
           for (int i = 0; i < vals.length; i++)
               l.add(Integer.parseInt(vals[i]));
           ans.add(l);
       }
       
       return ans;
       
       
   }
   
   void savePerm(int[] nums, Set preAns)
   {
       StringBuffer sb = new StringBuffer();
       
       int n = nums.length;
       for (int i = 0; i < n; i++)
       {
           sb.append(nums[i]);
           sb.append('_');
       }
       
       preAns.add(sb.toString());        
   }
   
   void swap(int[] nums, int a, int b)
   {
       int v = nums[b];
       nums[b] = nums[a];
       nums[a] = v;
   }
   
   void rotate(int[] nums, int i, int j)
   {
       Stack s = new Stack();
       for (int x = i; x <= j; x++)
       {
           s.push(nums[x]);
       }
       
       int x = i;
       while(!s.isEmpty())
       {
           int v = (Integer) s.pop();
           nums[x] = v;
           x++;
       }
   }
}
