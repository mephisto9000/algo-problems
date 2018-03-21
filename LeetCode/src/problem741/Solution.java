package problem741;


class Solution {
    
    int w;
    int h;
    
    int grid[][];
    
    Map<String, Integer> map;
    
   
    
    
 
    
    public int cherryPickup(int[][] grid) {
        h = grid.length;
        w = grid[0].length;
        
        this.grid = grid;
        
        map = new HashMap();
        
       
        
        int i = h-1;
        int j = w-1;
        
       
       int v = move(0,0, 0,0);
        
       if (v < 0)
    	   v  = 0;
       return v; 
          
        
    }
    
    
    int move(int i1, int j1, int i2, int j2)
    {
    	 if (i1 >= h || j1 >= w)
            return -100000;
    	
    	  if (grid[i1][j1]==-1)
          {
              //cache[i][j] = -100000;
              return -100000; //cache[i][j];
          }
    	  
    	  String key = i1 + " "+j1 + " "+i2+" "+j2;
    	  
    	  if (map.containsKey(key))
    		  return map.get(key);
    	  
    	  
    	  int sum = 0;
    	  
    	  if (grid[i1][j1] == 1)
    		  sum++;
    	  
    	  if (i1==h-1 && j1 == w-1 && i1==i2 && j1==j2)
    		  return sum;
    	  
    	  if (i2 >= h || j2 >=w)
    		  return -100000;
    	  
    	  if (grid[i2][j2]==-1)
    		  return -100000;
    	  
    	  if (grid[i2][j2] == 1 && (i1 != i2 && j1 != j2 ))
    	  {
    		  sum ++;
    	  }
    	  
    	  int v1 = move(i1+1, j1, i2+1, j2);
    	  int v2 = move(i1+1, j1, i2, j2+1);
    	  
    	  if (v2 > v1)
    		  v1 = v2;
    	  
    	  v2 = move(i1, j1+1, i2+1, j2);
    	  if (v2 > v1)
    		  v1 = v2;
    	  
    	  v2 = move(i1, j1+1, i2, j2+1);
    	  if (v2 > v1)
    		  v1 = v2;
    	  
    	  sum += v1;
    	  map.put(key, sum);
    	  
    	  return sum ;
    	  
    }
     
}