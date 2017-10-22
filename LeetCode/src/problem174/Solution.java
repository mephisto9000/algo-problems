package problem174;

import java.util.Arrays;

class Solution {
    int h;
    int w;
   
    int inf = Integer.MAX_VALUE;
    
   
    
    public int calculateMinimumHP(int[][] dungeon) {
    	
    	if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 0;
        
        h = dungeon.length;
        w = dungeon[0].length;
        
        int hp[][] = new int[h+1][w+1];
        for (int i = 0; i <= h; i++)
        	Arrays.fill(hp[i], inf);
        
        hp[h][w - 1] = 1;
        hp[h - 1][w] = 1;
        
        for (int i = h-1; i >=0; i--)
        {
        	for (int j = w-1; j >= 0; j--)
        	{
        		int v = Math.min(hp[i+1][j],  hp[i][j+1]) - dungeon[i][j];
        		
        		hp[i][j] = v <= 0 ? 1 : v;
        	}
        }
        
        return hp[0][0];
    }
     
    
}