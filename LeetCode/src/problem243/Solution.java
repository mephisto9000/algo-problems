package problem243;

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap();
        
        for (int i = 0; i < words.length; i++) {
            
            List<Integer> l = null;            
            if (map.containsKey(words[i]))
                l = map.get(words[i]);
            else
                l = new LinkedList();
            l.add(i);
            
            map.put(words[i], l);
        }
        
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        
        int dist = Integer.MAX_VALUE;
        for (Integer i1 : l1)
            for (Integer i2 : l2) {
                dist = Integer.min(dist, Math.abs(i2 - i1));
            }
        
        return dist;
    }
}