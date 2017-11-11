package problem139;


class Solution {

    int n;
    Map m;
    
    Map memo;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if (s == null || s.length() == 0)
            return false;
        
          m = new HashMap();
        
        n = s.length();
        
        Collections.sort(wordDict);
 
        Iterator it = wordDict.iterator();
        
        int maxIdx = 0;
 
        while(it.hasNext())
 
        {
            String word = (String) it.next();   //stack.pop();  //it.next();
            int idx = s.indexOf(word, 0);
            
            if (idx > maxIdx)
            	maxIdx = idx;
            
            while( idx != -1)
            {   
                List l;
                
                if (m.containsKey(idx))
                    l = (List) m.get(idx);
                else
                {
                    l = new LinkedList();
                    m.put(idx, l);
                }
                
                l.add(idx + word.length());
                
                idx = s.indexOf(word, idx + 1 ); //word.length() 
            }            
        }
        
        memo = new HashMap();
        
        
       
        
        return rec(0 );
        
    }
    
    boolean rec(int idx)
    {
        if (!m.containsKey(idx))
            return false;
        
 
        
        if (memo.containsKey(idx))
        {
        	int cacheV = (Integer) memo.get(idx);
        	
        	if (cacheV == 1)
        		return true;
        	if(cacheV == 0)
        		return false;
        }
        
        List l = (List) m.get(idx);
        
      
        Iterator it = l.iterator();
        while(it.hasNext())
        {
        	
        
            int v = (Integer) it.next();
            if (v == n)
            {
            	memo.put(idx, 1);
                return true;
            }
            else
                if (rec(v))
                {
                	memo.put(idx, 1);
                    return true;
                }
        }
        
        memo.put(idx, 0);
        return false;
    }
}