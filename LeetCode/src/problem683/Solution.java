package problem683;

class Solution {
    
    public int kEmptySlots(int[] flowers, int k) {
                
        TreeSet<Integer> ts = new TreeSet<>();
        
        for (int i = 0; i < flowers.length; i++) {                    
            Integer l = ts.lower(flowers[i]);
            Integer r = ts.higher(flowers[i]);
            if (l != null && l == flowers[i]-k -1)
                return i+1;
            if (r != null && r == flowers[i]+k+1)
                return i+1;                        
            ts.add(flowers[i]);
        }
                                        
        return -1;
        
    }
}