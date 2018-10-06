package problem355;

class Solution {
    int[] preorder;
    public boolean verifyPreorder(int[] preorder) {
        this.preorder = preorder;
        return rec(0, preorder.length); 
    }
    
    boolean rec(int idx, int endChildIdx) { 
        if (idx >= endChildIdx)
            return true;
        
        int m = idx + 1;
        while(m  < endChildIdx && preorder[m] < preorder[idx])
            m++;
                
        for (int x = m+1; x < endChildIdx; x++)
            if (preorder[x] <= preorder[idx])
                return false;
        
		return rec(idx+1, m) && rec(m, endChildIdx);
    }
}