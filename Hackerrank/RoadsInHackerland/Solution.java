

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the roadsInHackerland function below.
     */
	
	
	class City {
		int id;
		
		Set<Road> connections;
		
		public City(int id) {
			this.id = id;
			connections = new HashSet();
		}
		
		public void addRoad(Road newRoad) {
			connections.add(newRoad);
			newRoad.included = true;
		}
		
	}
	
	public class Road implements Comparable{
		int from;
		int to;
		int exp;
		boolean included;
		int repeats;
		
		
		
		public Road(int from, int to, int exp) {
			this.from = from;
			this.to= to;
			this.exp = exp;
			included = false;
		}

		@Override
		public int compareTo(Object o) {			
			Road other = (Road) o;			
			return exp - other.exp;					
		}
		
		public void setIncluded() {
			included = true;
		}
		
	}
	
	 int dfs(int idx) {
		 
		 if (visited[idx])
			 return rating[idx];
		 
		 City city = cities[idx];
		 
		 
		 
		 Iterator<Road> rit = city.connections.iterator();
		 
		 int kids = 0;
		 while(rit.hasNext()) {
			 Road r = rit.next();
			 
			 if (r.from-1 != idx)
				 kids += dfs(r.from-1) + 1;
			 else
				 
				 kids += dfs(r.to-1) + 1;
		 }
		 
		 visited[idx] = true;
		 rating[idx] = kids;
		 return kids;
	 }
	
     String roadsInHackerland( int n, int m,  Road[] roads) {
       
    	this.roads = roads;
    	
    	cities = new City[n];
    	visited = new boolean[n];
    	
    	for (int i = 0; i < n; i++)
    		cities[i] = new City(i+1);
    	
    	initTree(n);
    	
    	Arrays.sort(roads);
    	
        for (Road r : roads) {
        	if (union(r.from, r.to)) {
        		r.setIncluded();
        		
        		//if (rating[r.from] >= rating[r.to])
        		cities[r.from].addRoad(r);        		
        		cities[r.to].addRoad(r);
        		
        	}
        	        	
        }
    	
        
        for (int i = 0; i < n; i++) {
        	 if (parent[i+1]==i+1)
        		 dfs(i);
        }
        
        long tot = 0;
        
        for (int i = 0; i < m; i++)
        {
        	if (roads[i].included) {
        		tot += (1 << roads[i].exp) * (n - rating[roads[i].from]) * rating[roads[i].from];
        	}
        }
         
        
        //System.out.println(tot);
        StringBuilder sb = new StringBuilder();
        while(tot !=0)
        {
            sb.insert(0, tot & 1);
            tot = tot >> 1;
        }
        
        //System.out.println("now");
        return sb.toString();

    }
    
    int parent[];
    int rating[];
    
    Road[] roads;
    City[] cities;
    boolean visited[];
     
    
    void initTree(int n)
    {
    	parent = new int[n+1];
    	rating = new int[n+1];
    	
    	for (int i = 0; i <= n; i++)
    		parent[i] = i;
    }
    
    int findParent(int idx)
    {
    	
    	
    	if (parent[idx] != idx)
    		return findParent(parent[idx]);
    	return idx;
    }
    
   
    
    boolean union(int idx1, int idx2)
    {
    	int p1 = findParent(idx1);
    	int p2 = findParent(idx2);
    	
    	if (p1 != p2) {
    		parent[p1] = p2;    		 
    		return true;
    	}
    	
    	return false;
    }

     

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String[] nm = scanner.nextLine().split(" ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	//BufferedReader br = new BufferedReader(new FileReader("test1.txt"));

        String[] nm = br.readLine().split(" "); // scanner.nextLine().split(" ");
        
        
        
        int n = Integer.parseInt(nm[0] );

        int m = Integer.parseInt(nm[1] );

        Road[] roads = new Road[m];
       
        
        
        Solution sol = new Solution();
        for (int roadsRowItr = 0; roadsRowItr < m; roadsRowItr++) {
            String[] roadsRowItems = br.readLine().split(" "); //scanner.nextLine().split(" ");

            int from = Integer.parseInt(roadsRowItems[0]); //
            int to = Integer.parseInt(roadsRowItems[1]);
            int distExp =  Integer.parseInt(roadsRowItems[2]);
                        
            roads[roadsRowItr] = sol.new Road(from ,to, distExp);
            
        }

        
        String result = sol.roadsInHackerland(n, m,  roads);
        
         
        System.out.println(result);
    }
}

