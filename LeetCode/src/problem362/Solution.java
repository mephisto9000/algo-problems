package problem362;

class HitCounter {
    /** Initialize your data structure here. */
    
    Map<Integer, Integer> hitMap;
    
    public HitCounter() {
        hitMap = new HashMap();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (hitMap.containsKey(timestamp))
        {
            int v = hitMap.get(timestamp);
            hitMap.put(timestamp, ++v);
        }
        else
            hitMap.put(timestamp,1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        
        int v = 0;
        for (int i = timestamp - 300+1; i <= timestamp; i++)
        {
            if (hitMap.containsKey(i))
            {
                v += hitMap.get(i);
            }            
        }
        
        return v;
        
    }
}
/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */