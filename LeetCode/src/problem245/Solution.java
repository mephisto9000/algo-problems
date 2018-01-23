package problem245;

class Solution {
    
    Map<String, List<Integer>> map;
   public void init(String[] words) {
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
   
   public int shortestWordDistance(String[] words, String word1, String word2) {        
       
       
       init(words);
       
       List<Integer> l1 = map.get(word1);
       List<Integer> l2 = map.get(word2);
       
       int min = Integer.MAX_VALUE;
       for (int i1: l1)
           for (int i2: l2 )
           {
               int v = Math.min(min, Math.max(i1, i2) - Math.min(i1,i2) );
               
               if (v > 0)
                   min = v;
           }
       return  min; 
       
   }
   
   
}