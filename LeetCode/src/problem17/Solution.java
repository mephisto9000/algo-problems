package problem17;

class Solution {
    
    
    List<String> ans;
    Set<String> keys;
    
    String mtx[][];
    public List<String> letterCombinations(String digits) {
        
        ans = new LinkedList<String>();
        
        if (digits == null || digits.length() == 0)
            return ans;
        
        
        keys = new HashSet<String>();
        
        mtx = new String[][] {{" "," "," "," "},
            {"1","1","1","1"},
            {"a","b","c", ""},
            {"d","e","f", ""},
            {"g","h","i", ""},
            {"j","k","l", ""},
            {"m","n","o", ""},
            {"p","q","r", "s"},
            {"t","u","v", ""},
            {"w","x","y", "z"},
            {"*","*","*","*"},
            {"#","#","#","#"}
            
           };
        
        //digits.replace(*)
        rec(0, digits, "");
        
        return ans;
        
    }
    
    void rec(int idx, String str, String assemble)
    {
        if (idx == str.length())
        {
            if (!keys.contains(assemble))
            {
                keys.add(assemble);
                ans.add(assemble);
              
            }
              return;
        }
            //return "";
        
        char c = str.charAt(idx);
        
        int mtxIdx = 0;
        
        if (c == '*')
            mtxIdx = 10;
        else
        if (c == '#')
            mtxIdx = 11;
        else
            mtxIdx =(int)  c - '0';
        
        //tring v = re
        
        for (int i = 0; i < 4; i++)
        {
            String ccc = mtx[mtxIdx][i];
            if (ccc.equals(""))
                break;
                
            
            rec(idx+1, str, assemble + ccc);
        }
    }
    
}