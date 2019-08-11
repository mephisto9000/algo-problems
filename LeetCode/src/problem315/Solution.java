package problem315;

class Solution {
    
    public List<Integer> countSmaller(int[] nums) {    
        List<Integer> vals = new ArrayList<>();
        List<Integer> ans = new LinkedList();        
        for (int i = nums.length - 1; i>=0; i--) {
            int v = nums[i];
            
            int idx = Collections.binarySearch(vals, v);
            if (idx < 0) {
                idx = -idx-1;                                
            }
            while(idx-1 >= 0 && idx < vals.size() && vals.get(idx-1)==nums[i]) {
                idx --;            
            }
            vals.add(idx, v);
            ans.add(idx);                        
        }        
        Collections.reverse(ans);
        return ans;
    }         
