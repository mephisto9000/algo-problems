package problem739;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int tmp[] = new int[101];
        Arrays.fill(tmp,-1);
        int ans[] = new int[T.length];
        
        for (int i = T.length-1; i>= 0; i-- ) {
            for (int j = T[i]+1; j <= 100; j++)
                if (tmp[j] > 0) {
                    if (tmp[j]-i < ans[i] || ans[i] == 0)
                        ans[i] = tmp[j]-i;
                    //break;
                }
            tmp[T[i]] = i;                    
        }
        return ans;
        
    }
}