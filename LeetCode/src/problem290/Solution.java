package problem290;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        String words[] = str.split(" ");
        
        if (words.length != pattern.length())
            return false;
        
        Map<Character, String> m = new HashMap();
        Map<String, Character> revm = new HashMap();
        
        
        
        for (int i = 0; i < pattern.length(); i++)
        {
            char c = pattern.charAt(i);
            
            if (m.containsKey(c))
            {
                String v = m.get(c);
                if (!v.equals(words[i]))
                    return false;
                if (!revm.containsKey(words[i]) || revm.get(words[i])!=c)
                    return false;
            }
            else
            {
                m.put(c, words[i]);
                if (revm.containsKey(words[i]))
                    return false;
                revm.put(words[i], c);
            }
        }
        
        return true;
        
    }
}