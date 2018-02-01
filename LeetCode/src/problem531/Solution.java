package problem531;

class Solution {
    public int findLonelyPixel(char[][] picture) {
        
        if (picture == null || picture.length == 0 || picture[0].length == 0)
            return 0;
        
        int h = picture.length;
        int w = picture[0].length;
        
        int vcount[] = new int[h];
        int wcount[] = new int[w];
        
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
            {
                if (picture[i][j] == 'B')
                {
                    vcount[i] ++;
                    wcount[j] ++;
                }
            }
        
        int ans = 0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
            {
                if (vcount[i] == 1 && wcount[j] == 1 && picture[i][j] == 'B')
                    ans ++;
            }
        return ans;
    }
}