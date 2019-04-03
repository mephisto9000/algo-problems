package problem351;

class Solution {
    HashMap<Integer, int[]> pathMap;
    int m; 
    int n;
    int count = 0;
    Set<Integer> ans;
    public int numberOfPatterns(int m, int n) {
        
        pathMap = new HashMap();
        this.m = m;
        this.n = n;
        pathMap.put(13, new int[]{2});
        pathMap.put(19, new int[]{5});
        pathMap.put(17, new int[]{4});        
        pathMap.put(28, new int[]{5});
        pathMap.put(37, new int[]{5});
        pathMap.put(39, new int[]{6});
        pathMap.put(46, new int[]{5});
        pathMap.put(79, new int[]{8});
        int map = 0;
        ans = new HashSet(); 
        rec(-1, 0, 0);
        return count;
    }
    
    void rec(int lastKey, int map, int keys) {
        
        if (keys >= m) 
            count++;
        if (keys==n)
            return;
        
        for (int i = 1; i <= 9; i++) {
            if ((map & (1 << (i-1)))!=0)
                continue;
            
            if (lastKey!=-1) {
                int[]k = new int[2];
                k[0] = lastKey*10 +i;
                k[1] = i*10+lastKey;
                
                if (pathMap.get(k[0])==null && pathMap.get(k[1])==null) {
                     int t = map | (1 << (i-1));                                
                     rec(i, t, keys+1);
                }
                else
                {
                boolean found = false;
                for (int j = 0; j < 2; j++){
                    int kk = k[j];
                    int mandatoryKeys[] = pathMap.getOrDefault(kk, new int[]{});
                    if (mandatoryKeys.length > 0 ) {
                        for (int z = 0; z < mandatoryKeys.length; z++) {
                            if (((map & (1<<(mandatoryKeys[z]-1)))!=0) && !found)
                            {
                                found = true;
                                int t = map | (1 << (i-1));                                
                                rec(i, t, keys+1);
                                
                            }
                        }
                        
                    } 
                        
                 }
                }
                
            } else {
                
                int t = map | (1 << (i-1));                                
                rec(i, t, keys+1);
            }
        }
    }
}