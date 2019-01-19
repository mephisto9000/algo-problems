package problem809;

class Solution {
    public int expressiveWords(String S, String[] words) {        
        char lc = S.charAt(0);
        int cnt = 1;
        List<Character> chars = new ArrayList();
        List<Integer> cnts = new ArrayList();
        for (int i = 1; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == lc)
                cnt++;
            else
            {
                chars.add(lc);
                cnts.add(cnt);                
                lc = c;
                cnt = 1;
            }
        }        
        chars.add(lc);
        cnts.add(cnt);        
        int ans = 0;
        for (String w: words) {            
            int wi = 0;
            lc = w.charAt(0);
            cnt = 1;
            for (int i = 1; i < w.length(); i++) {
                char c = w.charAt(i);
                if (c == lc)
                    cnt++; 
                else {
                    if (lc != chars.get(wi) || cnt > cnts.get(wi) ||(cnt < cnts.get(wi)  && cnts.get(wi) < 3 ))
                        break;                    
                    wi++;
                    lc = c;
                    cnt = 1;
                }
            }                        
            if (wi < chars.size()-1 || lc != chars.get(wi) || cnt > cnts.get(wi) || (cnt < cnts.get(wi)  && cnts.get(wi) < 3 ))
                continue;
            ans++;                            
        }
        return ans;        
    }
}