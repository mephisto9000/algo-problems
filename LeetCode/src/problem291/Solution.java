package problem291;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Solution {
    
    Map<Character, String> map;
    Map<String, Character> invMap;
    String str;
    String pattern;
    int n;
    int pn;
    
    public boolean wordPatternMatch(String pattern, String str) {
        map = new HashMap();
        invMap = new HashMap();
        this.str = str;
        this.pattern = pattern;
        pn = pattern.length();
        n = str.length();
        
        
       return rec(0, 0);           
    }
    
    public boolean rec(int patternId, int strId)
    {
     	 if (patternId >= pn)
         {
              if (strId >= n)
                 return true;
             else
               return false; 
         }
         
        char c = pattern.charAt(patternId);
        StringBuffer sb = new StringBuffer();
        if (map.containsKey(c))
        {
            String v = map.get(c);
             
            int j = strId;
            
            while( j < n && sb.length() < v.length() )
            {
                sb.append(str.charAt(j));
                j++;
            }
            
            String vv = sb.toString().trim();
            if (!vv.equals(v))             
                return false;
                                                
            return rec(patternId + 1, strId + vv.length() );
        }
        else
        {
             int j = strId;
            
            while(  j < n)
            {
                sb.append(str.charAt(j));
                
                String v = sb.toString().trim();
                if (invMap.containsKey(v))
                {
                	j++;
                	continue;
                } 
                
                map.put(c, v);
                invMap.put(v, c);
                if (rec(patternId+1, strId + v.length()))
                    return true;
                                
                map.remove(c);
                invMap.remove(v);
                j++; 
            }
        }
        
        return false;
        
        
    }
}