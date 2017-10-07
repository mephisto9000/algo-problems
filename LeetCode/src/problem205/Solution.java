package problem205;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length())
            return false;
        
        Map<Character, Integer> map = new HashMap();
        Set <Character> used = new HashSet();
        char[] arr = new char[s.length()];
        
        for (int i = 0; i < s.length(); i++ )
        {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            //aa -> ab false
            
            //ab -> aa false
            if (!map.containsKey(c2))      
            {
            	if (used.contains(c1))
            		return false;
                map.put(c2, (int) c2 - (int)c1);
                used.add(c1);
            }
            
            arr[i] = (char) (c1 +   map.get(c2));
        }
        
        String tn = new String(arr);
        
        if (!t.equals(tn))
            return false;
        return true;
        
    }
}