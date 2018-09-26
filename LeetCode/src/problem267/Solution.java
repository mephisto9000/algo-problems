package problem267;

class Solution {
    
    int chars[];
    List<String> ans;
    int wtotal = 0;
    int center = -1;
    public List<String> generatePalindromes(String s) {
        chars = new int[256];
        ans = new LinkedList();
        
        for (int i = 0; i < s.length(); i++) {            
            int v =(int) s.charAt(i);
            chars[v] ++;
        }
        
        wtotal = 0;        
        for (int i = 0; i < 256; i++) {                       
            if (chars[i] % 2 != 0) {
             if (center >= 0)   
                 return ans;
                else {
                 center = i;
                 chars[i]--;   
                }
            }
            
            chars[i] = chars[i]/2;
            wtotal += chars[i];     
            
        }

        StringBuffer sb = new StringBuffer();
        rec(0, sb);
        return ans;
    }
    
    void rec(int idx, StringBuffer sb) {
        if (idx >= wtotal) {
            int mid = sb.length() / 2;
            if (center >= 0)
                sb.insert(mid,  Character.toString ((char) center));
            ans.add(sb.toString());
            if (center >= 0)
                sb.deleteCharAt(mid);    
            return;
        }
        for (int i = 0; i < 256; i++ ) {
            if (chars[i]>0) {                
                chars[i]--;
                sb.append(Character.toString ((char) i));
                sb.insert(0, Character.toString ((char) i));
                rec(idx+1, sb);
                chars[i]++;
                sb.deleteCharAt(sb.length()-1);
                sb.deleteCharAt(0);
            }
        }
    }
}