package problem170;

class TwoSum {

    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (map.containsKey(number)) {
            int v = map.get(number);
            map.put(number, v+1);
        }
        else
        {
            map.put(number, 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        
        List<Integer> l = new LinkedList(map.keySet());
        Iterator<Integer> it = l.iterator();
        while(it.hasNext()) {
            int v = it.next();
            if (!map.containsKey(v))
                continue;
            
            if (map.containsKey(value - v)) {
                if (!(map.get(value-v)==1 && value - v == v))
                    return true;
            }                                    
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */