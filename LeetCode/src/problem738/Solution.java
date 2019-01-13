package problem738;

class Solution {
    public int monotoneIncreasingDigits(int N) {        
        int ans = 0;
        int len = 0;
        int base = N;
        while (base > 0) {
            len ++;
            base /= 10;
        }
        
        int old = 0;
        int oldx = -1;
        int i = len;
        boolean flag = false;
        int rem = N;
        for (; i > 0; i--) {
            int d = ((int) Math.pow(10,i-1));
            int x = rem/d;
            rem = rem % d;                        
            if (flag) {
                old = old*10 + 9;
            } else {
            if (x >= oldx) {
                old = old*10 + x;
            } else {
                old =old*10-1;
                old = monotoneIncreasingDigits(old);
                flag = true;
            }
            oldx = x;
            }
        }
        return old;
    }
}