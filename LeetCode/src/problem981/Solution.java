package problem981;

class TimeMap {
    
    Map<String, List<Integer>> timeMap;
    Map<String, List<String>> valMap;

    /** Initialize your data structure here. */
    public TimeMap() {
        valMap = new HashMap<>();
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Integer> timeList = timeMap.getOrDefault(key, new ArrayList<>());
        timeMap.put(key, timeList);        
        timeList.add(timestamp);
        
        List<String> valList = valMap.getOrDefault(key, new ArrayList<>());
        valMap.put(key, valList);
        valList.add(value);                
    }
    
    public String get(String key, int timestamp) {
        
        if (!timeMap.containsKey(key))
            return "";
        List<Integer> timeList = timeMap.get(key);
        int idx = Collections.binarySearch(timeList, timestamp);
        if (idx == -1)
            return "";
        
        if (idx < 0) {
            idx = -idx-2;
        }
        List<String> valList = valMap.get(key);
        return valList.get(idx);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */