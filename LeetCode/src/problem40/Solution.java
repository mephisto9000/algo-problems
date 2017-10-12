package problem40;

class Solution {
    List<List<Integer>> ans;
    int nums[];
    int n;
    
    Set<List<Integer>> stash;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        ans = new LinkedList<List<Integer>>();
        
        if (candidates == null || candidates.length == 0)
            return ans;
        
        nums = candidates;
        Arrays.sort(nums);
        n = nums.length;
        stash = new HashSet<List<Integer>>();
        
        rec(0, target, new LinkedList<Integer>());
        
        return ans;
        
    }
    
    
    void rec(int idx, int target, List<Integer> l)
    {
        if (target == 0)
        {
            if (!stash.contains(l))
            {
                List nl = new LinkedList(l);
                ans.add(nl);
                stash.add(nl);
            }
            return;
        }
        
        if (idx >= n || target < 0)
            return;
        
        rec(idx + 1, target, l);
        
        l.add(nums[idx]);
        rec(idx + 1, target - nums[idx], l);
        l.remove(l.size() - 1);
    }
}