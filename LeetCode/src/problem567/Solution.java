package problem567;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int initArr[] = new int[26];
        int slidingArr[] = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            initArr[(int)c-'a']++;
        }
        
                
        int cnt = 0;
        
        for (int i = 0; i < s2.length(); i++) {
            if (i >= s1.length()) {
                int j = i - s1.length();  
                int idx = s2.charAt(j)-'a';
                if (initArr[idx] == slidingArr[idx]) {                                        
                   cnt -= initArr[idx];                    
                                   
                }
                slidingArr[idx]--;
            }
            int idx = s2.charAt(i)-'a'; 
            slidingArr[idx]++;
            if (initArr[idx] == slidingArr[idx])
                cnt += initArr[idx];                                                
            if (cnt == s1.length())
                return true;            
        }
        
        return false;                                
    }
}