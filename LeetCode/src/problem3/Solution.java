package problem3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        if (s == null || s.length() == 0)
            return 0;
        int startIdx = 0;
        int endIdx = 0;
        
        
        
        Map<Character, Integer> pos = new HashMap();
         
        
        StringBuffer sb = new StringBuffer();
        Set<Character> chars = new HashSet();
        int local = 0;
        int max = 0;
        while (true) 
        {
            char c = s.charAt(endIdx);
            
            if (!chars.contains(c))
            {
                chars.add(c);
                
                local ++;
            }
            else
            {
                int dupIdx = pos.get(c);
                for (int i = startIdx; i <dupIdx; i++)
                    chars.remove(s.charAt(i));
                
                 
                startIdx = dupIdx +1;
                local = endIdx - startIdx +1;
            }
            
            pos.put(c,endIdx);
            if (local > max)
                max = local;
            
            endIdx ++;
            if (endIdx == s.length())                              
                break;
            
        }
        
        return max;
        
    }
}