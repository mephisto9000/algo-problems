package problem131;

class Solution {
    
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new LinkedList();
        rec(0,s,new LinkedList());
        return ans;
    }
    
    void rec(int offset, String s, List<String> prefix) {
        if (offset == s.length()) {
            if (prefix.size() > 0)
                ans.add(new LinkedList(prefix));
            return;
        }
        
        for (int i = offset+1; i <= s.length(); i++) {
            String x = s.substring(offset, i);
            if (isPal(x)) {                
                prefix.add(x);
                rec(i, s, prefix);
                prefix.remove(prefix.size()-1);
            }
        }
    }
    
    
    boolean isPal(String s) {
        int i = 0; 
        int j = s.length()-1;
        while(i < j) {
            if (s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}