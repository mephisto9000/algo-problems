package problem728;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> ans = new LinkedList();
        
        for (int i = left; i <= right; i++) {
            int v = i;
            
            boolean add = true;
            while(v > 0) {
                int div = v % 10;
                
                if (div == 0 || i % div != 0) {
                    add = false;
                    break;
                }
                
                v = v / 10;                    
            }
            
            if (add)
                ans.add(i);
        }
        
        return ans;
        
    }
}