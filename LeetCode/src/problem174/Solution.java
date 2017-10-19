package problem174;

import java.util.Arrays;

class Solution {
    int h;
    int w;
    int[][]maze;
    int inf = Integer.MAX_VALUE;
    TempAns memo[][];
    
    TempAns outOfBounds = new TempAns(Integer.MIN_VALUE, 0);
    
    public class TempAns{
    	int min;
    	int total;
    	
    	public TempAns(int min, int total)
    	{
    		this.min = min; 
    		this.total = total;
    	}
    }
    
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 0;
        maze = dungeon;
        h = dungeon.length;
        w = dungeon[0].length;
        
        memo = new TempAns[h][w];
        
        for (int i = 0; i < h; i++)
            Arrays.fill(memo[i], null);
        
        //return -rec(0,0) + 1;
        int rec_ans= rec(h-1,w-1).min;
        
        if (rec_ans <= 0)
            return (1 - rec_ans);
        else
            return 1;
    }
    
    TempAns rec(int i, int j)
    {
        if (i < 0 || j < 0)
            return null; //outOfBounds;
        
        if (i == 0 && j == 0)
            return new TempAns(maze[i][j], maze[i][j]);//maze[i][j]; new 
        
        if (memo[i][j] != null)
            return memo[i][j];
        
        TempAns v1 = rec(i-1, j);
        TempAns v2 = rec(i, j-1);
        
        
        //memo[i][j] = Math.max(v1,v2);
        //int x = Math.max(v1.min, v2.min);
        
        if (v1 == null)
        	v1 = v2;
        else if (v2 != null && v1 != null)
        {
        if (v1.min < v2.min)
        	v1 = v2;
        }
        	
        
        int v = v1.total + maze[i][j];
        
        int x = Math.min(v1.min, v);
        
        //  if (v < x)
        //  	x = v;
                
        memo[i][j] = new TempAns(x, v);
        //return 
        	
        
        
        ///if (memo[i][j] < 0)
        //    memo[i][j] = Math.min(memo[i][j], memo[i][j] + maze[i][j]);
        //else
        ///    memo[i][j] = Math.max(memo[i][j], memo[i][j] + maze[i][j]);
        
        //new 
        
        return memo[i][j];
    }
    
}