package problem380;

class RandomizedSet {

    /** Initialize your data structure here. */
    
    int cnt ;
    int arr[];
    Map<Integer, Integer> map;
    
    public RandomizedSet() {
        arr = new int[65535];
        map = new HashMap();
        cnt = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
       
        
        if (map.containsKey(val))
            return false;
        
        arr[cnt] = val;
        map.put(val, cnt++);
        
       return  true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if (!map.containsKey(val))
            return false;
        
        int idx = map.get(val);
        map.remove(val);
        int v = arr[cnt-1];
        cnt --;
        
        if (cnt == idx)
            return true;
        arr[idx] = v;
        map.put(v, idx);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        
        Random rand = new Random();

        int  idx = rand.nextInt(cnt);       
        
        
        return arr[idx];
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */