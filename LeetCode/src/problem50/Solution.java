package problem50;

class Solution {
    
    Map<Integer, Double> map = new HashMap();
    public double myPow(double x, int n) {    
       if (n < 0) {
           double v = x * xPow(x, -n -1);
           return 1d / v;
       } else
           return xPow(x, n);
        
    }
    
    double xPow(double x, int n) {
         
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        
        if (map.containsKey(n))
            return map.get(n);
        
        int l = n /2;
        int r = n - l;
        double ans = myPow(x, l) * myPow(x, r);
        
        map.put(n, ans);
        
        return ans;
    }
}