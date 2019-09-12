package problem1180;

class Solution {
    Map<String, Integer> uniques;
    public int countLetters(String S) {
        uniques = new HashMap<>();        
        for (int i = 0; i < S.length(); i++) {
            calc(S, i,i);
        }
        
        int ans = 0;
        for (Map.Entry<String, Integer> entry : uniques.entrySet()) {
            ans += entry.getValue();
        }
        return ans;
    }
    
    void calc(String s, int l, int r) {
        if (r >= s.length() || s.charAt(l)!=s.charAt(r)) {
            return;
        }
        String tmp = s.substring(l, r+1);
        int repeats = uniques.getOrDefault(tmp, 0);
        uniques.put(tmp, repeats+1);
        calc(s,l,r+1);            
    }
}