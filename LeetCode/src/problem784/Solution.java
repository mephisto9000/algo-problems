package problem784;

class Solution {
    String str;
    public List<String> letterCasePermutation(String S) {
        str = S;
        if (S == null || S.length() == 0) {
            List<String> ans = new LinkedList();
            ans.add("");
            return ans;
        }
    
        return rec(0);
    }
    
    List<String> rec(int idx) {
        if (idx >= str.length())
            return new LinkedList<String>();
        
        List<String> ans = rec(idx+1);
        
        char c = str.charAt(idx);
        
        if (Character.isLetter(c) )
        {
            char c1 = Character.toUpperCase(c);
            char c2 = Character.toLowerCase(c);
            
            List<String> newAns = new LinkedList();
            
            if (ans.size() > 0)
            for (int i = 0; i < ans.size(); i++) {
                newAns.add(c1 + ans.get(i));
                newAns.add(c2 + ans.get(i));
            }
            else
            {
                newAns.add(c1+"");
                newAns.add(c2+"");
            }
            
            return newAns;
        }
        else {
            List<String> newAns = new LinkedList();
            if (ans.size() > 0)
            for (int i = 0; i < ans.size(); i++) {
                newAns.add(c + ans.get(i));
                
            }
            else
                newAns.add(c+"");
            return newAns;
        }
        
    }
}