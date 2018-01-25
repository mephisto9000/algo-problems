package problem694;

class Solution {
    
    class  Node implements Comparable
    {
        boolean marked;
        int i;
        int j;
        int val;
        
        public Node(int i, int j, int val)
        {
            this.i = i;
            this.j = j;
            this.val = val;
            marked = false;
        }
        
        public int compareTo(Object other)
        {
            Node o = (Node) other;
            
            int ii = i - o.i;
            
            if (ii != 0)
                return ii;
            
            return j - o.j;
        }
    }
   
   Node nodes[][];
   
   int h;
   int w;
   
   boolean isValid(int i, int j)
   {
       if (i < 0 || j < 0 || i >= h || j >= w)
           return false;
       return true;
   }
   
   
   //returns top, left
   void dfs(int i, int j, List<Node> list)
   {
       if (!isValid(i,j))
           return; 
       
       Node node = nodes[i][j];
       if (node.val != 1 || node.marked)
           return;
       node.marked = true;
       list.add(node);
       
       dfs(i-1, j, list);
       dfs(i+1, j, list);
       dfs(i, j-1, list);
       dfs(i, j+1, list);
       
       
   }   
         
   public int numDistinctIslands(int[][] grid) {
       if (grid == null || grid.length == 0 || grid[0].length == 0)
           return 0;
       
       h = grid.length;
       w = grid[0].length;
       
       nodes = new Node[h][w];
       
       Set<String> ans = new HashSet();
       
       
       for (int i = 0; i < h; i++)
           for (int j = 0; j < w; j++)
               nodes[i][j] = new Node(i,j, grid[i][j]);
       
       for (int i = 0; i < h; i++)
           for (int j = 0; j < w; j++)
           {
               if (!nodes[i][j].marked)
               {
                   List<Node> list = new LinkedList();
                   dfs(i,j,list);
               
                   Collections.sort(list);
                   
                   StringBuffer sb = new StringBuffer();
                   
                   Iterator<Node> it = list.iterator();
                   Node ref = null;
                   
                   while(it.hasNext())
                   {
                	   
                       Node node = it.next();
                       
                       if (ref == null)
                    	   ref = node;
                                                                      
                       sb.append((node.i - ref.i)+"_"+(node.j - ref.j)+"_");
                       ref = node; 
                   }
                   if (!(sb.toString().isEmpty()))   
                   {                	    
                	   ans.add(sb.toString());
                   }
               }
           }
       
       return ans.size();
       
       
   }
}