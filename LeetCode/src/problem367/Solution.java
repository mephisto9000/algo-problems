package problem367;

class Solution {
    public boolean isPerfectSquare(int num) {
        
        int n = num;
        int i = 0;
        int j = n;
        
        int mid = 1;//j/2;
        int oldm = -1;
        while(i <= j)
        {
            mid = i + (j-i)/2;
            
            if (mid == oldm)
                break;
            
            oldm = mid;
            long square = (long) mid * (long) mid;
            
            if (square == num)
                return true;
            
            if (square > n)            
                j = mid - 1;
            else
                i = mid + 1;            
        }
        
       
        
        return false;
            
        
    }
}