package problem860;

class Solution {
    int mybills[];
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        mybills = new int[101];
        for (int i = 0; i < n; i++) {
            mybills[bills[i]]++;
            int b = bills[i];
            int rem = b-5;
            System.out.println(i);
            for (int j = rem; j > 0; j--) {
                if (rem == 0)
                    break;
                if (mybills[j] > 0) {
                    if (rem / j > mybills[j]) {
                    	rem -= mybills[j]*j;
                        mybills[j] = 0;
                    } else {
                        mybills[j] -= rem/j;
                        rem = rem%j;
                    }
                        
                }
            }
            
            if (rem > 0)
                return false;
        }
        return true;
    }
}