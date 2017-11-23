package problem210;


class Solution {
    
    class Pair
    {
        int idx;
        int parentIdx;
        
        public Pair(int idx, int parentIdx)
        {
            this.idx = idx;
            this.parentIdx = parentIdx;
        }
    }
    
    class Course
    {
    	List<Pair> pairs;
    	int idx ;
    	public Course(int idx)
    	{
    		this.idx = idx;
    		pairs = new LinkedList<Pair>();
    	}
    	
    	void addPair(Pair p)
    	{
    		pairs.add(p);
    	}
    	    	
    }
    
    Pair pairs[];
    int n;
    
    List<Integer> reverse;
    boolean visited[];
    Course cources[];
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        n = numCourses; 
       int pn = prerequisites.length;
        pairs = new Pair[pn+1];
        reverse = new LinkedList();
        visited = new boolean[n+1];
         int ans[] = new int[n ];
        
        Arrays.fill(visited, false);
        
        cources = new Course[n];
        for (int i = 0; i < n; i++)
        	cources[i] = new Course(i);
        
        for (int i = 0; i < prerequisites.length; i++)
        {
            Pair p = new Pair(prerequisites[i][0], prerequisites[i][1]);
            
            pairs[i] = p;
            cources[prerequisites[i][0]].addPair(p);
        }
        
        int deps = 0;
        for (int i = 0; i < n; i++)
            if (cources[i].pairs.size() > 0)
                deps ++;
        
        
        if (deps == n)
            return new int[]{};
        	 
        
        
        for (int i = 0; i < n; i++)
        {
            
            check(i);
        }
        
       
 
        int z = 0;
        for (int i = 0; i < reverse.size(); i++)
        {
            ans[i] = reverse.get(i);
            z++;
        }
        
        for (int i = 0; i < n; i++)
        {
            if (!visited[i] )            
                ans[z++] = i;
            
        }
        
        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++)
        {
        	if (!bfsTest(ans[i]) )
        	   return new int[]{};
        }
            
        return ans;
        
    }
    
    
    
    boolean bfsTest(int idx)
    {
    	Course c = cources[idx];
    	
    	
    	
    	visited[idx] = true;
    	for (Pair p : c.pairs)
    	{
    		if (!visited[p.parentIdx])
    			return false;
    		
    		 
    	}
    	
    	
    	return true;
    }
    
    void check(int idx)
    {
        if (visited[idx])
            return;
         
        visited[idx] = true;
         
        Course c = cources[idx];
        
        for (Pair p : c.pairs)
        {
 
            check(p.parentIdx);
        }
            
        reverse.add(idx);
    }
    
    
    
}