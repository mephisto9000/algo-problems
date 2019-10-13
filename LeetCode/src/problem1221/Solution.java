package problem1221;

class Solution {
    public int balancedStringSplit(String s) {
        
        int l = 0;
        int r = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i)=='L') {
                if (r > 0) {
                    r--;
                } else {
                    l++;
                }
            } else {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
            if (l == r) {
                ans ++;
                l = 0;
                r = 0;
            }
        }
        
        return ans;
        
    }
}