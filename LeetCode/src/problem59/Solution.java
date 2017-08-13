package problem59;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		
		
		int x = 4;
		
		Solution sol = new Solution();
		int [][]arr = sol.generateMatrix(x);
		
		for (int i = 0; i < x; i++)
		{
			for (int j = 0; j < x; j++)
				System.out.print(arr[i][j]+" ");
			
			System.out.println();
		}

	}
	
	
	
        
	    public enum Direction {
	        RIGHT, DOWN, LEFT, UP
	    }
	    
	    public int[][] generateMatrix(int n) {
	        
	        Set<String> visited = new HashSet<String>();
	        
	        
	        
	        int[][] ans = new int[n][n];
	        
	        for (int i = 0; i < n; i++)
	            Arrays.fill(ans[i],-1);
	        
	        Direction dir = Direction.RIGHT;
	        int i = 0;
	        int j = 0;
	        int z = 1;
	        
	        
	        
	        while(z<=n*n)
	        {
	            //if (!visited.contains(i+"_"+j))
	            
	                ans[i][j] = z;
	                z++;
	                visited.add(i+"_"+j);
	                switch(dir)
	                {
	                    case RIGHT:
	                        if (j < (n-1) && (!visited.contains(i+"_"+(j+1))))
	                            j++;
	                            else
	                            {
	                                i++;
	                                dir = Direction.DOWN;
	                            }
	                    break;
	                    case DOWN:
	                        if (i < (n-1) && (!visited.contains((i+1)+"_"+j)))
	                            i++;
	                            else
	                            {
	                                j--;
	                                dir = Direction.LEFT;
	                            }
	                    break;
	                    case LEFT:
	                        if (j > 0 && (!visited.contains(i+"_"+(j-1))))
	                            j--;
	                            else
	                            {
	                                i--;
	                                dir = Direction.UP;
	                            }
	                    break;   
	                    case UP:
	                        if (i > 0 && (!visited.contains((i-1)+"_"+j)))
	                            i--;
	                            else
	                            {
	                                j++;
	                                dir = Direction.RIGHT;
	                            }
	                    break;    
	                        
	                    
	                }
	        }
	        
	        
	                            
	        return ans;
	        
	        
	    
	}
	

}
