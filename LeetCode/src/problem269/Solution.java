package problem269;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
	
	class Node {
		public int idx;
		public List<Integer> children;
		boolean isInit = false;
		
				
		public Node(int idx)
		{
			this.idx = idx;
			children = new LinkedList();
		}
		
		public void addChild(int idx)
		{
			children.add(idx);
		}
	}
	
    
    
    Node nodes[];
    boolean visited[];
    int n;
    List<Integer> list;
    
    
    void process(int idx)
    {
    	if (idx < 0 || idx >= n)
    		return;
    	
    	if (visited[idx])
    		return;
    	
    	visited[idx] = true;
     	    	
    	Node node = nodes[idx];
    	node.isInit = true;  
    	Iterator<Integer> cit = node.children.iterator();
    	while(cit.hasNext())
    	{
    		Integer cidx = cit.next();
    		process(cidx);
    	}
    	
    	list.add(0, idx);    	
    }
    
    void unite(char c1, char c2)
    {
    	nodes[c1-'a'].addChild(c2-'a');

		nodes[c1-'a'].isInit = true;
		nodes[c2-'a'].isInit = true;
    }
    
    boolean dfs(int idx, Set<Integer> set)
    {
     	if (set.contains(idx))
    		return false;
    	
    	set.add(idx);
    	
    	Iterator<Integer> it = nodes[idx].children.iterator();
    	    	
    	while(it.hasNext())
    	{
    		int cidx = it.next();
    		
    		if (!dfs(cidx, set))
    			return false;
    	}
    	
    	set.remove(idx);
    	
    	return true;
    }
    
    public void init(String words[])
    {
    	for (int i = 0; i < words.length; i++)
    	{
    		for (int j = 0; j < words[i].length(); j++)
    		{
    			char c = words[i].charAt(j);
    			nodes[c-'a'].isInit = true;
    		}
    	}
    }
    
    public String alienOrder(String[] words) {

    	nodes = new Node[26];
    	visited = new boolean[26];
    	Arrays.fill(visited, false);
    	n = 26;
    	
    	list = new LinkedList();
    	
    	for (int i = 0; i < 26; i++)
    	{
    		nodes[i] = new Node(i);
    	}
    	
    	init(words);
    	
    	for (int i = 1; i< words.length; i++)
    	{
    		char c1 = words[i-1].charAt(0);
    		char c2 = words[i].charAt(0);
    		
    		for (int j = 0; j < words[i].length(); j ++)
    		{    			 
    			if (words[i-1].length() > j && words[i-1].charAt(j) == words[i].charAt(j))
    			{	
    				continue;
    			}
    			else
    			{
    				if (words[i-1].length() > j )
    				{
    					c1 = words[i-1].charAt(j);
    					c2 = words[i].charAt(j);
    					
    					if (c1 != c2)
    						unite(c1,c2);
    				}
    				break;
    			}
    			 
    		}
    	}
    	 
    	for (int i = 0; i < 26; i++)
    	{
    		if (nodes[i].isInit &&   !dfs(i, new HashSet()))
    			return "";
    	}
    	
    	for (int i = 0; i < 26; i++)
    	{
    		if (nodes[i].isInit)
    			process(i);
    	}
    	    	
    	Iterator<Integer> it = list.iterator();
    	StringBuffer sb = new StringBuffer();
    	
    	while(it.hasNext())
    	{
    		sb.append((char) (it.next() +'a'));
    	}
    	return sb.toString();
    }
                    
}