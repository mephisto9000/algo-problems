package problem734;

class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        
        if (words1.length != words2.length)
            return false;
        
        Map<String, List<String>> map = new HashMap();
        
        for (int i = 0; i < pairs.length; i++) {
            String w1 = pairs[i][0];
            String w2 = pairs[i][1];
            
            helper(map,w1,w2);
            helper(map,w2,w1);           
        }        
        
        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];
            
            if (w1.equals(w2))
                continue;
            //if (w1.equals(map.get(w2)))
            if (helper2(w1, map.get(w2)))
                continue;
            if (helper2(w2, map.get(w1)))
                continue;
            return false;
        }
        
        return true;
        
    }
    
    boolean helper2(String s1, List<String> l) {
        if (l == null)
            return false;
        
        Iterator<String> it = l.iterator();
        
        while(it.hasNext()) {
            String t = it.next();
            if (s1.equals(t))
                return true;
        }
        return false;
    }
    
    void helper(Map<String, List<String>> map, String w1, String w2) {
        List<String> l = null;
        if (map.containsKey(w1)) {
            l = map.get(w1);
        }
        else {
            l = new LinkedList();
            map.put(w1,l);
        }
        l.add(w2);
    }
}