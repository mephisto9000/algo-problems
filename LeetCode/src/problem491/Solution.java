package problem491;

class Solution {
    int nums[];
    int n;
    Stack<Integer> st;
    List<List<Integer>> ans;
    Set<String> utilSet;
        
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        ans = new LinkedList();
        
        if (nums == null || nums.length == 0)
            return ans;
        
        this.nums = nums;
        n = nums.length;
        st = new Stack();
        utilSet = new HashSet();
       
        
        rec(0);
        return ans;
        
        
    }
    
    void rec(int idx )
    {
        if (idx >= n)
        {
            //ans.add(new ArrayList(st));
            
            if (st.size() < 2)
                return;
            
            List l = new ArrayList(st);
            
            StringBuffer sb = new StringBuffer();
            Iterator it = l.iterator();
            while(it.hasNext())
            {
                sb.append((Integer) it.next());
                sb.append(" ");
            }
            
            if (!utilSet.contains(sb.toString()))
            {
                ans.add(l);
                utilSet.add(sb.toString());                    
            }              
            
            return;
        }
        
        if (st.isEmpty() || nums[idx]>= st.peek())
        {
            st.push(nums[idx]);
            rec(idx+1);
            st.pop();            
        }
        
        rec(idx+1);
        return;
    }
    
    
}