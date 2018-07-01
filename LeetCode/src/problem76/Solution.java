package problem76;

class Solution {
    public String minWindow(String s, String t) {
                
        Map<Character, Integer> refMap = new HashMap();
        
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer v = refMap.get(c);
            if (v == null)
                v = 0;
            refMap.put(c, v + 1);
        }
        
        int i = 0;
        int j = 0;
        String ans = s;
        
        boolean reached = false;
        Map<Character, Integer> tmpMap = new HashMap();
        while(i < s.length() ) {
            int hits = 0;
                                    
            if (!reached) {
            while(i < s.length() && hits < t.length()) {
                char c = s.charAt(i);
                Integer v = tmpMap.get(c);
                Integer refV = refMap.get(c);                

                if (v == null)
                    v = 0;
                
                if (refV != null && ++v <= refV ) {
                    hits ++;                    
                }
                tmpMap.put(c, v);
                i++;
                
            } 
            } else {
                while (i < s.length()) {
                    char c = s.charAt(i);
                    if (refMap.containsKey(c)) {
                        Integer v = tmpMap.get(c);
                         tmpMap.put(c, ++v);
                        i++;
                        break;
                    }
                    i++;
                    
                }
            }
            
            if (hits >= t.length())
                reached = true;                
            
            while(j < s.length() && j <= i) {
                char c = s.charAt(j);
                Integer v = tmpMap.get(c);
                Integer refV = refMap.get(c);
                
                if (v == null)
                    v = 0;
                
                if (refV != null && --v < refV)
                    break;
                
                tmpMap.put(c, v);
                j++;
            }
                        
            if (ans.length() > i - j)
                ans = s.substring(j, i);
        }
        
        if (!reached)
            return "";
        return ans;
        
    }
}