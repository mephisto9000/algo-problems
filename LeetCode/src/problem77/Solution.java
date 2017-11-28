package problem77;

class Solution {    
    List<List<Integer>> ans;    
    
    int n;
    int k;
    Stack st;
    
    public List<List<Integer>> combine(int n, int k) {
        
        this.n = n;
        this.k = k;
        
        ans = new LinkedList();
        st = new Stack();        
        rec(0, 0 );
        return ans;        
    }
    
    void rec(int idx, int level )
    {
        
         if (st.size() >= k)
            {
                List tmp = new LinkedList(st);
                ans.add(tmp);
                
                if (level > 0)
                    return;                
            }
        
        if (level >= k)
            return;
        
        for (int i = idx; i < n; i++)
        {                        
            st.push(i+1);                     
            rec(i + 1, level + 1 );
            st.pop();
             
        }        
    }
    
}