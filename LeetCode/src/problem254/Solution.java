package problem254;

class Solution {
    
    List<List<Integer>> ans;
    
    Map<String, List> memo;
    
    public List<List<Integer>> getFactors(int n) {
        
        ans = new LinkedList();
        
        if (n == 1)
        {
            
            
            return ans;
        }
        
        memo = new HashMap();
        
        rec(n, new LinkedList());
        
        //ans.removeLast();
        ans.remove(ans.size() - 1);
        return ans;
        
    }
    
    void rec(int n, LinkedList<Integer> l)
    {
        for (int i = 2; i <= n; i++)
        {
            if (n % i == 0)
            {
                l.add(i);
                
                if (n - i == 0)
                {
                    List tmp = new LinkedList(l);
                    Collections.sort(tmp);
                    String key = listToStr(tmp);
                    
                    if (!memo.containsKey(key))
                    {
                        ans.add(new LinkedList(tmp));
                        memo.put(key, tmp);
                    }
                    
                    
                }
                else                
                    rec(n/i, l);
                
                l.removeLast();
            }
        }
    }
    
    String listToStr(List l)
    {
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < l.size(); i++)
        {
            sb.append(l.get(i));
            sb.append(',');
        }
        
        return sb.toString();
    }
    
    
}