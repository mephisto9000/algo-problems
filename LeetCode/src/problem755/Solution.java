package problem755;

class Solution {    
    int heights[];
    final int LEFT = -1;
    final int RIGHT = 1;
    int lastMin;
    public int[] pourWater(int[] heights, int V, int K) {        
        this.heights = heights;        
        for (int i = 0; i < V; i++) {
            lastMin = K;
            tryDrop(K, K, LEFT);
            if (lastMin == K)
                tryDrop(K,K, RIGHT);
            heights[lastMin]++;
        }                
        return heights;        
    }
                
    void tryDrop(int idx, int parentIdx, int  direction) {
        if (idx < 0 || idx >= heights.length || heights[idx]> heights[parentIdx] )
            return; 
        if (heights[idx] < heights[parentIdx] ) {
            lastMin = idx;
        }
        tryDrop(idx + direction, idx, direction);            
    }
}