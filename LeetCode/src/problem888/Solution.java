package problem888;

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        
        int as = 0;
        int bs = 0;
        int ans[] = new int[2];
        
        Set<Integer> bset = new HashSet();
        
        for (int i = 0; i < A.length; i++)
            as += A[i];
        for (int i = 0; i < B.length; i++) {
            bs += B[i];
            bset.add(B[i]);            
        }
        
        int diff = Math.abs(as - bs)/2;
        int sign = -(int) Math.signum(as-bs);
        for (int i = 0; i < A.length; i++) {
            if (bset.contains(A[i] + sign*diff)) {
                  ans[0] = A[i];
                  ans[1] = A[i]+sign*diff;
                  break;
              }            
        }
        return ans;
        
    }
}