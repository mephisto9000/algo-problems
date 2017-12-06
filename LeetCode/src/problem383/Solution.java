package problem383;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        Map<Character, Integer> map = new HashMap();
        
        for (int i = 0; i < ransomNote.length(); i++)
        {
            char c = ransomNote.charAt(i);
            if (!map.containsKey(c))
            {
                //int v = map.get(c);
                map.put(c,1);
            }
            else
            {
                int v = map.get(c);
                map.put(c,++v);
            }
        }
        for (int i = 0; i < magazine.length(); i++)
        {
            char c = magazine.charAt(i);
            
            if (map.containsKey(c))
            {
                int v = map.get(c);
                
                if (v > 1)
                {                    
                    map.put(c, --v);
                }
                else
                    map.remove(c);
            }
        }
        
        if (map.size()==0)
            return true;
        else
            return false;
        
    }
}