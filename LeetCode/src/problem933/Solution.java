package problem933;

class RecentCounter {
    
    TreeSet<Integer> ts;

    public RecentCounter() {
         ts = new TreeSet();
    }
    
    public int ping(int t) {
        
        ts.add(t);
        Integer key = ts.ceiling(t-3000);
        
        return ts.subSet(key, true, ts.last(), true).size();
        
        
        //subSet(E fromElement, E toElement)
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */