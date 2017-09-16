package problem517;

class Solution {
    public int findMinMoves(int[] machines) {
                
        int n = machines.length;
        
        int total = 0;
        
        int avg = 0;
        for (int i = 0; i < n; i++)
        {
            total += machines[i];
            
        }
        
        if (total % n > 0)
            return -1;
        
        avg = (total/n);
        
        int moves = 0;
        
        int max = 0;
        int accumulate = 0;
        for (int i = 0; i < n; i++)
        {
            int cm = machines[i] - avg;
            
            accumulate += cm;
            
            int tmp = Math.abs(accumulate) > cm ? Math.abs(accumulate): cm;
            if (tmp > max)
                max = tmp;
            
        }
        
        
        return max;
    }
}
