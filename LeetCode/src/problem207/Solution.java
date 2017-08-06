package problem207;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	boolean[] used;
	
	public class Node {
		
		public List<Node> neighbors;
		//boolean visited = false;
		public int idx;
		
		public Node(int idx)
		{
			neighbors = new LinkedList<Node>();
			this.idx= idx;
		
			
		}
		
		public void addNode(Node n)
		{
			if (!neighbors.contains(n))
				neighbors.add(n);
		}
		
		public boolean visit()
		{
			//System.out.println("idx == "+idx);
			
			if (used[idx] == true )					
				return false;
			
			
			used[idx] = true;
			
			for (int i = 0; i < neighbors.size(); i++)
			{
				//if
				Node n = neighbors.get(i);
				if (n.visit() == false)
					return false;
			}
			
			used[idx] = false;
			
			return true;
		}
	}
	
	List<Node> graph; 
	
	
	public static void main(String[] args)
	{
		Solution sol = new Solution();
		int[][] p = {{0,1},{0,2},{1,2}};
		boolean r = sol.canFinish(3, p);
		
		
			//System.out.println("r == "+(r?"true":"false"));
	}
	
	 public boolean canFinish(int numCourses, int[][] prerequisites) {
	        graph = new LinkedList<Node>();
	        
	        for (int i = 0; i < numCourses; i++)
	        {
	        	Node node = new Node(i);
	        	graph.add(node);
	        }
	        
	        for (int i = 0; i < prerequisites.length; i++)
	        {
	        	//for  (int j = 0; j < prerequisites)
	        	Node n1 = graph.get(prerequisites[i][0]);
	        	Node n2 = graph.get(prerequisites[i][1]);
	        	
	        	n1.addNode(n2);
	        }
	        used = new boolean[numCourses];
	        Arrays.fill(used, false);
	        
	        
	        
	        for (int i =0; i < numCourses; i++)
	        {
	        	
	        	Node n = graph.get(i);
	        	
	        	Arrays.fill(used, false);
	        	
	        	if (n.visit() == false)
	        		return false;
	        }
	        return true;
	    }

}
