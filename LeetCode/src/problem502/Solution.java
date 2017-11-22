package problem502;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    
    class Project implements Comparable{
            int profit;
            int capital;
            
            public Project(int profit, int capital)
            {
                this.profit = profit;
                this.capital = capital;
            }

			@Override
			public int compareTo(Object o) {
				
				Project op = (Project) o;
				
				if (this.capital < op.capital)
					return -1;
				
				if (this.capital > op.capital)
					return 1;
				
				return 0;
			}
        }
        
    class ProjectComparator implements Comparator<Project> {
    	
    		 
    	
            public int compare(Project a, Project b)
            {
            	            	
                if (a.profit > b.profit)
                    return -1;
            	
                if (a.profit < b.profit)
                    return 1; 
            	
                
                return 0;
                                
            }
            
        }
    
    
    
    
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        
        Map<Integer, PriorityQueue> m = new HashMap();
        int n = Profits.length;
         
        List<Project> l = new LinkedList();
        
        for (int i = 0; i < n; i++)
        {
        	Project p = new Project(Profits[i], Capital[i]);
        	l.add(p);        	
        }
        
        Collections.sort(l);
        PriorityQueue pq = new PriorityQueue(n, new ProjectComparator());
        
        
        while(k>0)
        {
        	//Project p = l.get(0);
        	
        	
        	while(l.size() > 0)   //p != null && p.capital <= W)
        	{
        		Project p = l.get(0);
        		
        		boolean stop = true;
        		
        		if (p.capital <= W)
        		{
        			pq.add(p);
        			l.remove(0);
        			stop = false;
        		}
        		
        		if (stop)
            		break;	
        		
        	}
        	
        	if (pq.size() == 0)
        		break;
        	
        	Project p  = (Project) pq.remove();
        	
        	W += p.profit;
        	
        	
        	k--;
        }
                                                                      
        return W;
    }
}


