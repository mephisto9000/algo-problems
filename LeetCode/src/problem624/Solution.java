package problem624;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        
        List<Integer> mins = new ArrayList();
        List<Integer> maxs = new ArrayList();
        for(List<Integer> l : arrays) {
            mins.add(l.get(0));
            maxs.add(l.get(l.size()-1));
        }
        
        Collections.sort(mins);
        Collections.sort(maxs);
        
        int dist = Integer.MIN_VALUE;
        for (List<Integer> l : arrays) {
            int lb = l.get(0);
            int ub = l.get(l.size()-1);
            dist = Math.max(dist, Math.abs(lb-findMax(maxs, ub)));
            dist = Math.max(dist, Math.abs(ub-findMin(mins, lb)));
                            
        }
        return dist;
        
    }
    
    int findMax(List<Integer> l, int v) {
        for (int i = l.size()-1; i>=0; i--) {
            int x = l.get(i);
            if (v == x)
                v = Integer.MIN_VALUE;
            else
                return x;
        }
        return -1;
    }
    
    int findMin(List<Integer> l, int v) {
        for (int i = 0; i < l.size(); i++) {
            int x = l.get(i);
            if (v == x)
                v = Integer.MAX_VALUE;
            else
                return x;
        }
        return -1;
    }
    
}