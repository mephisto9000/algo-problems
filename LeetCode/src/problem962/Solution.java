package problem962;

class Solution {       
    public int maxWidthRamp(int[] A) {        
        Map<Integer, List<Integer>> map = new HashMap();
              
        for (int i = 0; i < A.length; i++) {
            List<Integer> l = map.getOrDefault(A[i], new ArrayList());            
                l.add(i);   
            map.put(A[i],l);
        }        
        Arrays.sort(A);        
        int min = Integer.MAX_VALUE;        
        int totLen = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && A[i]==A[i-1])
                continue;
            List<Integer> l = map.get(A[i]);
            for (int j = 0; j < l.size(); j++) {
                int v = l.get(j);
                if (min > v)
                    min = v;
                totLen = Math.max(totLen, v-min);
            }
        }
        return totLen;                        
    }
}