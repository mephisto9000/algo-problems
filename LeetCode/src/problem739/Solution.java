package problem739;


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int t[] = temperatures;
        
        Stack<Integer> st = new Stack();
        int ans[] = new int[t.length];
        
        Map<Integer, Integer> map = new HashMap();
        
        for (int i = t.length-1; i >= 0; i--) {
            int cnt = 0;    
            
            while(!st.empty() && t[st.peek()] <= t[i]) {
                                            
                int x = st.pop();
                
                if (map.containsKey(x))
                	cnt += map.get(x);                
                cnt++;
            }
            
            
            
            if (st.empty()) {                
                ans[i] = 0;
            }
            else {               
                ans[i] = cnt+1;
                map.put(i, cnt); 
            }
            
            st.push(i);
                
            
        }
        
        return ans;
    
    }            
    
}