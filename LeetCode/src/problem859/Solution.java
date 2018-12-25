package problem859;

class Solution {
    public boolean buddyStrings(String A, String B) {
        
        int c = 0;
        char a1=' ';
        char b1=' ';
        
        if (A.length() != B.length())
            return false;
        if (A.equals(B)) {
            int cnt[] = new int[26];
            for (int i = 0; i < A.length(); i++) {
                int idx = A.charAt(i)-'a';
                cnt[idx]++;
            }
            for (int i = 0; i < 26; i++) 
                if (cnt[i]%2 == 0 && cnt[i]!=0 )
                    return true;
            return false;
                
        }
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i)!=B.charAt(i)) {                
                if ((++c) > 2)
                    return false;
                if (c == 1) {
                    a1 = A.charAt(i);
                    b1 = B.charAt(i);
                }
                if (c == 2) {
                    if (A.charAt(i)!=b1 || B.charAt(i)!=a1)
                        return false;
                }
            }
        }
        return true;
        
    }
}