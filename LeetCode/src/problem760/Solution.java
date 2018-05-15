package problem760;

class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Deque<Integer>> map = new HashMap();
        
        for (int i = 0; i < B.length; i++) {
            Deque<Integer> d = null;
            if (map.containsKey(B[i])) {
                d = map.get(B[i]);
                
            }
            else {
                d = new LinkedList();
                map.put(B[i], d);
            }
            d.addLast(i);
                
        }
        
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            ans[i] = map.get(A[i]).pollFirst();
        }
        return ans;
            
        
    }
}