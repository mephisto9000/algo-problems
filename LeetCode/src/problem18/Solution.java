package problem18;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        int n = nums.length;
        Map<Integer, List<List<Integer>>> map = new HashMap();
        for (int i = 0; i < n-1; i++) {
            
            
           
            for (int j = i+1; j < n; j++) {
                int sum = nums[i]+ nums[j];
                List<Integer> l = new LinkedList();
                l.add(i);
                l.add(nums[i]);
                l.add(nums[j]);
                if (map.containsKey(sum)) {
                    map.get(sum).add(l);
                }
                else {
                    List<List<Integer>> lll = new LinkedList();
                    lll.add(l);
                    map.put(sum, lll);
                }
                                
            }
                        
        }
        
        //
        
        Set<List<Integer>> s = new HashSet();
        for (int i = 0; i < n-3; i++)
            for (int j = i+1; j < n-2; j++)
            {
                
                if (map.containsKey(target - nums[i] - nums[j])) {
                    List<List<Integer>> lists = map.get(target - nums[i] - nums[j]);
                    
                    for (List<Integer> l : lists) {
                        if (l.get(0) <= j)
                            continue;
                        List<Integer> x = new LinkedList();
                        x.add(nums[i]);
                        x.add(nums[j]);
                        x.add(l.get(1));
                        x.add(l.get(2));
                        Collections.sort(x);
                        
                        s.add(x);
                        
                        
                    }
                }
            }
        
        List<List<Integer>> ans = new LinkedList(s);
        
        return ans;
        
    }
}