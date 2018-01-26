package problem370;

class Solution {
    
    int n;
    public int[] getModifiedArray(int length, int[][] updates) {
        n = length;
        
        int ans[] = new int[n];
        
        for (int i = 0; i < updates.length; i ++)
        {
            for (int j = updates[i][0]; j <= updates[i][1]; j++)
                ans[j]  += updates[i][2];
        }
        
        return ans;
        
    }
}