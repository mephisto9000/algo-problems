package problem697;

class Solution {
    public int findShortestSubArray(int[] nums) {
        
        Map<Integer, List<Integer>> map = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            List<Integer> l = map.getOrDefault(k, new LinkedList());
            map.put(k, l);
            l.add(i);            
        }
        
        int maxFreq = 0;
        int maxLen = 100000;
        
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> l =  entry.getValue();
                        
            if (l.size() > maxFreq) 
                maxFreq = l.size();
        }  
        
         for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> l =  entry.getValue();
            if (l.size() == maxFreq && (l.get(l.size()-1) - l.get(0) + 1) < maxLen) {
                maxLen = l.get(l.size()-1) - l.get(0) + 1;
            }         
         }
     
        
        return maxLen;
        
    }
}