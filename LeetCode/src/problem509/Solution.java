package problem509;

class Solution {
    public int fib(int N) {
        
        int a[] = new int[2];
        a[1] = 1;
        
        if (N < 2)
            return a[N];
        
        for (int i = 2; i <= N; i++) {
            int v = a[0] + a[1];
            a[0] = a[1];
            a[1] = v;
        }
        
        return a[1];
        
    }
}