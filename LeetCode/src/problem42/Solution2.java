package problem42;

class Solution {
    public int trap(int[] height) {
      
      int h = height.length;
      int lmap[] = new int[h];
      int rmap[] = new int[h];
      
      int max = 0;
      for (int i = 0; i < h; i++) {
        if (height[i] > max)
          max = height[i];
        
        lmap[i] = max;
      }
      
      max = 0;
      for (int i = h-1; i >= 0; i--) {
        if (height[i] > max)
          max = height[i];
        
        rmap[i] = max;
      }
      
      int ans = 0;
      for (int i = 0; i < h; i++) {
        int v = Math.min(lmap[i], rmap[i]) - height[i]; 
        ans+= (v > 0)?v:0;
      }
      return ans;
        
    }
}