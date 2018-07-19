package problem443;

class Solution {
    public int compress(char[] chars) {
        
        int slowIdx = 0;
        char oldVal = 65535;        
        int cnt = 0;
        
        for (int i = 0; i < chars.length; i++) {
            char x = chars[i];
            
            if (x != oldVal) {
                if (oldVal != 65535) {
                    if (cnt > 1)                        
                        slowIdx += insertNum(chars, cnt, slowIdx);                                            
                }
                chars[slowIdx++] = x;
                oldVal = x;
                cnt = 1;
            }
            else
                cnt++;
        }
        
        if (cnt > 1)
            slowIdx += insertNum(chars, cnt, slowIdx);
        
        return slowIdx;
    }
    
    int insertNum(char[] chars, int num, int idx) {
        String s = String.valueOf(num);
        
        for (int  i = 0; i < s.length(); i++) {
            chars[idx+i] = s.charAt(i);
        };
        
        return s.length();
    }
}