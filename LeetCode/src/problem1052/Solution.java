package problem1052;

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        
        int min = 0;
        int n = customers.length;
        int c[] = customers;
        int g[] = grumpy; 
        for (int i = 0; i < n; i++) {
            min += g[i]==0?c[i]:0;
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            int j = i - X;// + 1;
            
            min += g[i] > 0?c[i]:0;
            min -= (j >=0 && g[j]>0)?c[j]:0;
            
            max = Math.max(min, max);
            
        }
        
        return max;
        
    }
}