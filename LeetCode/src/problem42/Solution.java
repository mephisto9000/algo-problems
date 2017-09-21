package problem42;




class Solution {
    public int trap(int[] height) {
        
        if (height == null || height.length <2 )
            return 0;
        
        int n = height.length;
        int ans = 0;
        
        int lid = -1;
        int lh = 0;
        
        
        for (int i = 0; i < n; i++)
        {
            if (height[i] > lh)
            {
                lh = height[i];
                lid = i;
            }
        }
        
        int rid = -1;
        int rh = 0;
        for (int i = n-1; i >= 0; i--)
        {
            if (height[i] > rh)
            {
                rh = height[i];
                rid = i;
            }
        }
        
        int h = 0;
        int hi = -1;
        for (int i = 0; i <= lid; i++)
        {
            if (height[i] > h)
            {
                h = height[i];
                hi = i;
            }
            else
            {
                ans += (h - height[i]);
            }
        }
        h = 0;
        hi = -1;
        
        for (int i = n-1; i >= rid; i--)
        {
            if (height[i] > h)
            {
                h = height[i];
                hi = i;
            }
            else
            {
                ans += (h - height[i]);
            }
        }
        
        for (int i = lid; i <= rid; i++)
        {
            ans += (lh - height[i]);
        }
        
        return ans;
        
    }
}