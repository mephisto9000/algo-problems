package problem380;

class RandomizedSet {
    
    List<Integer> list;
    Map<Integer, Integer> valToPos;
    int cnt;
   Random rand = new Random(); 
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
      list = new ArrayList<>();
      valToPos = new HashMap<>();
      cnt = 0;      
      
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
      boolean ans = !valToPos.containsKey(val);
      if (ans) {
        valToPos.put(val, cnt++);
        list.add(val);
      }
      return ans;        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      boolean ans = valToPos.containsKey(val);
      if (ans) {
        int remPos = valToPos.get(val);
        valToPos.remove(val);
        int endVal = list.remove(cnt-1);
        if (endVal != val) {
          valToPos.put(endVal, remPos);
          list.set(remPos, endVal);
        }
        cnt--;        
      }
      return ans;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {          
        int randIdx = 0;
        if (cnt > 0) 
          randIdx = rand.nextInt(cnt);
      
      return list.get(randIdx);        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */