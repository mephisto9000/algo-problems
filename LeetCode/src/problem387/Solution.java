package problem387;

class Solution {
    public int firstUniqChar(String s) {
        
        if (s == null || s.length() == 0)
            return -1;
        
        int lastPos[] = new int[26];     
        Set<Integer> used = new HashSet();
        
        for (int i = 0; i < 26; i++)        
            lastPos[i] = Integer.MAX_VALUE;
                
        for (int i = 0; i<s.length(); i++)
        {
            int idx = s.charAt(i)-'a';
            if (!used.contains(idx))
            {
                lastPos[idx] = i;
                used.add(idx);
            }
            else
                lastPos[idx] = Integer.MAX_VALUE;
            
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <26; i++)
        {
            min = Math.min(min, lastPos[i]);
        }
        
        if (min == Integer.MAX_VALUE)
            min = -1;
        return min;                                
    }
}