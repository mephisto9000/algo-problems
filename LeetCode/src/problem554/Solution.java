package problem554;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        
        Map<Integer, Integer> m = new HashMap();
        
        Iterator<List<Integer>> lit = wall.iterator();
        
        int len = 0;
        
        while(lit.hasNext())
        {
            List<Integer> row = lit.next();
            
            int pos = 0;
            Iterator<Integer> rit = row.iterator();
            while(rit.hasNext())
            {
                int v = rit.next();
                pos += v;
                
                if (!m.containsKey(pos))
                {
                    m.put(pos,1);
                }
                else
                {
                    int val = m.get(pos);
                    m.put(pos, ++val);
                }
                
                if (pos > len)
                    len = pos;
            }
            
            
        }
        
        
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet())
        {
            //System.out.println(entry.getKey() + "/" + entry.getValue());
            
            if (entry.getKey() < len && entry.getValue() > max)
                max = entry.getValue();
        }
        
        return wall.size() - max;
        
    }
}