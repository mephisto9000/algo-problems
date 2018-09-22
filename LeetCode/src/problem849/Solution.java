package problem849;

class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int dist = -1;
        int start = -1;
        int end = -1;
        for (int i = 0; i < seats.length; i++) {
            
            if (seats[i] == 0) {
                if (start == -1)
                    start = i;
                end = i;
            }
            else
                {
                if (start == 0)
                    dist = Math.max((end-start) + 1, dist);
                else
                    dist = Math.max((end-start)/2 + 1, dist);
                start = -1;
                end = -1;
                }
        }
        
        if (start >= 0)
            dist = Math.max((end-start) + 1, dist);
        
        return dist;
    }
}