package problem409;

class Solution {
    public int longestPalindrome(String s) {
        
        Map<Character, Integer> map = new HashMap();
        
         
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (map.containsKey(c))
            {
                Integer v = map.get(c);
                map.put(c, ++v);
                
                 
            }
            else
            {
                map.put(c, 1);
            }                
        }
        
        int len = 0;
        
        //boolean oneSet = false;
        int max = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer v = entry.getValue();
            if (v % 2 != 0  )
            {
                max = 1;
                break;
            }
        }
        
        len += max;
        
        
        
    
	for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        Integer v = entry.getValue();
    
            if (v % 2 == 1)
                v--;
            len += v;
       
	}
        
        return len;
        
    }
}