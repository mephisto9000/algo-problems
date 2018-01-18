package problem249;

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
        int n = strings.length;
        
        List<List<String>> ans = new LinkedList();
        
        for (int i = 0; i < n; i++)
        {
            if (strings[i] == null)
                continue;
            
            List<String> tmp = new LinkedList();
            tmp.add(strings[i]);
            
            for (int j = i + 1; j < n; j++)
            {               
                if (same(strings[i], strings[j]))
                {
                    tmp.add(strings[j]);
                    strings[j] = null;
                }
            }
            
            ans.add(tmp);             
        }                
        return ans;        
    }
        
    boolean same(String a, String b)
    {
        if (a == null || b == null)
            return false;
        
        if (a.length() != b.length())
            return false;
                        
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        
        char off1 = (char) (a.charAt(0) - 'a');
        char off2 = (char) (b.charAt(0) - 'a');
        
        for (int i = 0; i < a.length(); i++)
        {
            char c1 = (char) (a.charAt(i) - off1);
            char c2 = (char) (b.charAt(i) - off2);
            
            if ( c1 < 'a')
                c1 += 26;
            
            if (c2 < 'a')
                c2 += 26;
            
            sb1.append(c1);
            sb2.append(c2);
        }
        
        if (sb1.toString().equals(sb2.toString()))
            return true;
        
        return false;               
    }
}