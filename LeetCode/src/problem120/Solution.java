package problem120;

public class Solution {
	
    
    int h = 0;
    List<Integer> results = null;
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;                
        
        h = triangle.size();
         
        
        rec(triangle, 1);
        return results.get(0);
        
    }
    
    void rec(List<List<Integer>> triangle, int idx )
    {
        if (idx < h)
            rec(triangle, idx + 1 );
        
        if (idx == h)
        {
            
            results = new ArrayList<Integer>();
            
            List<Integer> l = triangle.get(idx - 1);
            
            for (int i = 0; i < l.size(); i++)
                results.add(i, l.get(i));
            
            return;
        }
        
        List<Integer> l = triangle.get(idx-1);
        
        Iterator it = l.iterator();
        int i = 0;
        
        List<Integer> prelim = new ArrayList<Integer>();
        
        while(it.hasNext())
        {
            int v = (Integer) it.next();
            
            int s1 = (Integer) results.get(i) + v;
            int s2 = (Integer) results.get(i+1) + v;
            
            prelim.add(Math.min(s1,s2));
            
            i++;
        }
        
        results = prelim;
        
    }
        
}