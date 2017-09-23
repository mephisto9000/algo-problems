package problem15;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return new LinkedList();
        
        List ans = new LinkedList();
        
        Map m = new HashMap();
        
        Set cache = new HashSet();
        
        
        int n = nums.length;
        
        
        
        Arrays.sort(nums);
        
        for (int i = n-1; i >= 0; i--)
        {
            //m.put(nums[i]);
            List<Integer> l ;
            if (!m.containsKey(nums[i]))
            {
                l = new LinkedList<Integer>();
                m.put(nums[i],l);
                l.add(i);
            }
            else
                l = (List) m.get(nums[i]);
            
            
        }
        
        int[] tmp = new int[3];
        
        for (int i = 0; i < n; i++)
        {
            //if(i > i+1 && nums[j] == nums[j-1])
            //    int s = nums[i] + nums[j];
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            for (int j = i+1; j < n; j++)
            {
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                int s = nums[i] + nums[j];
                
                if (m.containsKey(-s))
                {
                    List l = (List) m.get(-s);
                    
                    Iterator it = l.iterator();
                    
                    while(it.hasNext())
                    {
                    int v = (Integer) it.next();
                    if (v == i || v == j)
                        continue;
                    
                   // int tmp[]  = new int[3];
                    tmp[0] = nums[i];
                    tmp[1] = nums[j];
                    tmp[2] = nums[v];
                    
                    Arrays.sort(tmp);
                    String stmp = tmp[0] + " " + tmp[1] + " "+tmp[2];
                        if(cache.contains(stmp))
                            continue; 
                    List t = new LinkedList();
                    t.add(nums[i]);
                    t.add(nums[j]);
                    t.add(nums[v]);
                            
                    ans.add(t);
                    cache.add(stmp);
                            
                    break;
                    }
                    
                     
                }
                
            }
    }
        
        return ans;
        
    }
}
