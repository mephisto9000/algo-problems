package problem91;

class Solution {
    Map<Integer, Character> dict;
    
    int memo[];
    
    public int numDecodings(String s) {
        dict = new HashMap();        
        int num = 1;        
        for (int i = 1; i <= 26; i++)
        {
            char c = (char) ('A' - 1 + i);            
            dict.put(i,c);
        }
        
        if (s.length() == 0)
        	return 0;
        
        memo = new int[100000];
        Arrays.fill(memo, -1);
        
        return rec(s, 0);       
    }
    
    int rec(String s, int idx)
    {
        if (idx >= s.length())
            return 1;
        
        int a1 = Character.getNumericValue(s.charAt(idx));
        if (a1 == 0)
            return 0;
        
        
        if (memo[idx] >=0)
        	return memo[idx];
        
        if ((idx + 1) >= s.length())        
            return 1;
            
        
        int ans = 0;
       // if (a1 > 0)
        {
            /// good
            //int 
            if (dict.containsKey(a1))
            {
                ans += rec(s, idx + 1);
            }
            
            int a2 = Character.getNumericValue(s.charAt(idx+1));
            if (dict.containsKey(a1*10 + a2))
            {
                ans += rec(s, idx +2);
            }
        }
        
        memo[idx] = ans;
        
        return ans;
        
    }
}