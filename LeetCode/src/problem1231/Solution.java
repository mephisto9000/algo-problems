package problem1231;

class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        
        long total = 0;
        long minSweet =0; 
        int min = Integer.MAX_VALUE;
        int n = sweetness.length;
        for (int i = 0; i < n; i++) {
            total += sweetness[i];
            min = Math.min(min, sweetness[i]);
        }

        long answer = min;
        while(minSweet <= total) {

            long curSweet = 0;
            int friends  = 0;
            
            long locMin = Integer.MAX_VALUE;
            long curMaxSweet = (minSweet + total) / 2L;
                       
            for (int i = 0; i < n; i++) {
                 curSweet += sweetness[i];
                
                if (curSweet >= curMaxSweet) {                    
                    locMin = Math.min(locMin, curSweet);
                    friends ++;
                    curSweet = 0;
                }
            }            

            if (friends < K+1 ) {               
                total = curMaxSweet  - 1;
            } else {
                minSweet = curMaxSweet + 1 ;
                answer =   Math.max(answer, locMin);
            }
        }
        
        return (int) answer;
        
    }
}