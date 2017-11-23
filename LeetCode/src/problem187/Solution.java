package problem187;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        int n = s.length();
        
        
        Map<String, Integer> m = new HashMap();
        Set ans = new HashSet();
        for (int i = 0; i <= n - 10; i++)
        {
            String ss = s.substring(i, i + 10);
            
 
            if (!m.containsKey(ss))
            	m.put(ss, 0);
            
            int v = m.get(ss);
            m.put(ss, ++v);
            
            if (v > 1)
            	ans.add(ss);
        }
        
        
        
        List<String> ansList = new LinkedList();
        Iterator it = ans.iterator();
        while(it.hasNext())
            ansList.add((String) it.next());
        
        return ansList;
        
    }
}