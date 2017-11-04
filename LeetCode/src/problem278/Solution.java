package problem278;


public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        
        
        boolean stop = false;
        
        int i = 1;
        int j = n;
        int mid = n / 2;
        int oldMid = n;
        while(i <= j)
        {
            if (mid == oldMid)
                break;
            
            mid = i + (j - i)/2;    
            
            if (isBadVersion(mid))
            {
                j = mid-1;
            }
            else
            {
                i = mid +1;
            }
        }
        
        if (isBadVersion(i)) return i;
        return n;
        
    }
}