package problem459;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        List<String> subs = new LinkedList<>();
        Map<String, Integer> hkMap = new HashMap<>();
        
        if (s == null || s.length() <= 1)
            return false;
        
        for (int i = s.length()/2; i > 0; i--) {
            String k = s.substring(0, i);
            subs.add(k);
            hkMap.put(k, k.hashCode());
        }
        
        for (String sub : subs) {
            int idx = 0;
            boolean flag = true;
            while(idx+sub.length() <= s.length()) {
                String tmp = s.substring(idx, idx+sub.length());
                int k = hkMap.getOrDefault(tmp, -1);
                if (hkMap.get(sub)!=k)
                    break;
                idx+=sub.length();
            }
            if (idx == s.length())
                return true;
        }                
        return false;
                
    }
}