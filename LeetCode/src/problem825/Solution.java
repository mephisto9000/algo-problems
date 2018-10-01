package problem825;

class Solution {
    public int numFriendRequests(int[] ages) {
        
        int cnt = 0;
        int buckets[] = new int[120];
        for (int i  = 0; i < ages.length; i++) 
            buckets[ages[i]-1]++;
        
        for (int i = 1; i <= buckets.length; i++)
            for (int j = 1; j <= buckets.length; j++) {                
                if (j > 0.5*i + 7 && j<= i && !(j > 100 && i < 100)) {                    
                    int inc = 0;
                    if (i == j)
                        inc = buckets[j-1]*(buckets[i-1]-1); 
                    else
                        inc = (buckets[j-1])*(buckets[i-1]);                                         
                    cnt+= inc;                                            
                }                
            }                
        return cnt;        
    }
}