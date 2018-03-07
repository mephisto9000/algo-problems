package problem90;

class Solution {
    
    int n;
    int[] nums;
    List<List<Integer>> ans;
    Set<String> ansSet;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        
        n = nums.length;
        
        ans = new LinkedList();
        ansSet = new HashSet();
                           
        List<Integer> tmpAns = new LinkedList();
        rec(0, tmpAns);
         
        return ans;
                
    }
    
    void rec(int idx, List<Integer> tmpAns)
    {
        if (idx >= n)
        {
            String s = listToStr(tmpAns);
            
            if (!ansSet.contains(s))
            {
                ansSet.add(s);
                ans.add(new LinkedList(tmpAns));
            }
            return;
        }
        
        tmpAns.add(nums[idx]);
        
        rec(idx + 1, tmpAns);
        tmpAns.remove(tmpAns.size()-1);
        rec(idx + 1, tmpAns);
    }
    
    String listToStr(List<Integer> list)
    {
        StringBuffer sb = new StringBuffer();
        
        for (Integer s : list)
        {
            sb.append(s+" ");
        }
        return sb.toString();
    }
}