package problem636;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {        
        int[] ans = new int[n];            
        Stack<Integer> st = new Stack();
        int lastTime = 0;
        int time = 0;                 
        for (String s : logs) {
            String vals[] = s.split(":");
            int id = Integer.valueOf(vals[0]);
            boolean isStart = vals[1].equals("start")?true:false;
            
            lastTime = time;
            time = Integer.valueOf(vals[2]);
            
            if (isStart) {                
                if (!st.isEmpty()) {
                    int lastId = st.peek();
                    ans[lastId] += (time - lastTime) -1;
                }                
                st.push(id);
            } else {                                
                st.pop();
                ans[id] += (time - lastTime) + 1;
            }
        }                 
        return ans;        
    }
}