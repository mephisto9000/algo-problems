package problem737;

class Solution {
    
    Map<String, String> map;
    
    public String findParentKey(String key) {
        if (!map.containsKey(key)) 
            map.put(key, key);
        
        String v = map.get(key);
        
        if (v.equals(key))
            return key;
        else
            return findParentKey(v);
    }
    
    public void union(String key1, String key2) { 
        
        String v1 = findParentKey(key1);
        String v2 = findParentKey(key2);
        
        map.put(v1,v2);        
            
    }
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        
        if (words1.length != words2.length)
            return false;
        
        map = new HashMap();        
        
        
        for (int i = 0; i < pairs.length; i++) {
            union(pairs[i][0], pairs[i][1]);
        }
        
        
        for (int i = 0; i < words1.length; i++) {
            
            if (!findParentKey(words1[i]).equals(findParentKey(words2[i])))
                return false;
            
        }
        
        return true;
        
    }
}
