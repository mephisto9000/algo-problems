package problem332;


class Solution {
	
	 
	class Node implements Comparable<Node>
	{
		String name;
		List<Node> children;
		Set<Integer> used;
		
		
		public void useChild(int idx)
		{
			used.add(idx);
		}
		
		public boolean isUsed(int idx)
		{
			return used.contains(idx);
		}
		
		public void freeChild(int idx)
		{
			used.remove(idx);
		}
		
		
		public Node(String name)
		{
			this.name = name;
			children = new ArrayList();
			used = new HashSet();
		}
		
		public void addNode(Node node)
		{
			children.add(node);
		}
		
		public Node getNode(int idx)
		{
			return children.get(idx); //poll();
		}

 

		public int compareTo(Node arg0) {
			
			return name.compareTo(arg0.name);
		}
		
	}
	int n;
	 
	
	Map<String, Node> nodeMap;
	List<Node> nodes;
	
    public List<String> findItinerary(String[][] tickets) {
    	
    	this.n = tickets.length;
    	
    	nodeMap = new HashMap();
    	nodes = new ArrayList();
    	
    	for (int i = 0; i < n; i++)
    	{
    		String from = tickets[i][0];
    		String to = tickets[i][1];
    		
    		Node nodeFrom = null;
    		Node nodeTo = null;
    		if (!nodeMap.containsKey(from))
    		{
    			nodeFrom = new Node(from);
    			nodeMap.put(from, nodeFrom);
    			nodes.add(nodeFrom);
    		}
    		else
    			nodeFrom = nodeMap.get(from);
    		
    		if (!nodeMap.containsKey(to))
    		{
    			nodeTo = new Node(to);
    			nodeMap.put(to, nodeTo);
    			nodes.add(nodeTo);
    		}
    		else
    			nodeTo = nodeMap.get(to);
    		
    		nodeFrom.addNode(nodeTo);
    		
    	}
    	
    	for (int i = 0; i< nodes.size(); i++)
    	{
    		Node node = nodes.get(i);
    		Collections.sort(node.children);
    	}
    	
    	List<String> ans = new LinkedList();
    	dfs("JFK", ans);
    	return ans;
    }
    
    List<String> dfs(String src, List<String> ans)
    {
    	
    	Node node = nodeMap.get(src);
    	ans.add(node.name);
    	
    	if (ans.size() == n + 1)
    		return ans;
    	  	
    	for (int i = 0; i < node.children.size(); i++)
    	{
 
    		if (node.isUsed(i))
    			continue;
    		
    		node.useChild(i);
    		
    		
    		List<String> tmp = dfs(node.getNode(i).name, ans);
    		if (tmp.size() == n+1)
    			return tmp;
    		
    		node.freeChild(i);
    		
    	}
    	
    	 
    	
    	ans.remove(ans.size() - 1);
    	
    	return ans;
 
    }
    
}