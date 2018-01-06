package problem244;

class WordDistance {
    
    Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap();
        
        int i = 0;
        for(String w : words)
        {
            if (!map.containsKey(w))
            {            
                List<Integer> l = new ArrayList();
                map.put(w, l);
            }         
           
            List l =map.get(w);
            l.add(i);
            
            i++;
        }
    }

    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        
        int min = Integer.MAX_VALUE;
        for (int i1: l1)
            for (int i2: l2 )
            {
                min = Math.min(min, Math.max(i1, i2) - Math.min(i1,i2));
            }
        return  min; 
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */