import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Solution {
	
	int n; // num of malls
	int m; // num of roads;
	int k; // num of types of fish
	
	String src = null;
	
	
	Mall[] malls;
	
	
	int timeMtx[][];
	int states = 0;
	
	
	public class Mall
	{
		
		int fishNum = 0;
		List<Integer> fish;
		
		
		List<Edge> edges;
		
		int fishMask = 0;
		int id;
	}
	
	public class Edge
	{
		Mall m1;
		Mall m2;
		int time;
	}
	
	
	public int calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		String vals[] = br.readLine().split(" ");
		
		n = Integer.parseInt(vals[0]);
		m = Integer.parseInt(vals[1]);
		k = Integer.parseInt(vals[2]);
		
		malls = new Mall[n];
		
		
		//read malls
		for (int i = 0; i< n; i++)
		{
			vals = br.readLine().split(" ");
			
			Mall mall = new Mall();
			
			mall.id = i;
			mall.fish = new LinkedList<Integer>();
			mall.edges = new LinkedList<Edge>();
			
			int fishNum = Integer.parseInt(vals[0]);
			
			mall.fishNum = fishNum;
			
			for (int j = 0; j < fishNum; j++ )
			{
				int tmpFish = Integer.parseInt(vals[j+1]);
				mall.fish.add(tmpFish);
				mall.fishMask |= 1 << (tmpFish -1);
				
			}
			
			malls[i] = mall;
			
			
		}
		
		//read roads
		for (int i = 0; i < m; i++)
		{
			vals = br.readLine().split(" ");
			
			int from = Integer.parseInt(vals[0]) - 1;
			int to = Integer.parseInt(vals[1]) - 1;
			
			int time = Integer.parseInt(vals[2]);
			
			Edge edge = new Edge();
			
			edge.m1 = malls[from];
			edge.m2 = malls[to];
			edge.time = time;
			
			malls[from].edges.add(edge);
			malls[to].edges.add(edge);
			
		}
		
		/*
		for (int i = 0; i < n; i++)
		{
			System.out.println("mask " + i + " == "+malls[i].fishMask);
		}
		*/
		states = (int) Math.pow(2, k) - 1; 
		
		int ans = kindaDijkstra(); 
		
		
		return ans;
		
	}
	
	 
	public class ShopKey implements Comparable
	{
		int idx;
		int state;
		
		
		@Override
		public boolean equals(Object o )
		{
			ShopKey out_sk =  (ShopKey) o;
			
			if (out_sk.idx == this.idx && out_sk.state == this.state)
				return true;
			else
				return false;
			
		}


		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			//return 0;
			ShopKey out_sk =  (ShopKey) o;
			
			if (out_sk.idx == this.idx && out_sk.state == this.state)
				return 0;
			
			if (out_sk.idx < this.idx )
			{
				if (out_sk.state < this.state)
					return -1;
				else
				///if (out_sk.state > this.state)
					return 1;
			}
			else
				return 1;
		}
	}
	
	public int kindaDijkstra()
	{
		//boolean[][] visited = new boolean[n][states];
		//Arrays.fill(visited, false);
		
		timeMtx = new int[n][states+1];
		int inf = Integer.MAX_VALUE;
		
		for (int i =0; i < n; i++)
		{
			Arrays.fill(timeMtx[i], inf);
			//Arrays.fill(visited[i], false);
		}
		
		timeMtx[0][0] = 0;
		
		ShopKey srcKey = new ShopKey();
		srcKey.idx = 0;
		srcKey.state = malls[0].fishMask;
		
		timeMtx[0][malls[0].fishMask] = 0;
		
		
		LinkedHashMap<ShopKey, Integer> statMap = new LinkedHashMap<ShopKey, Integer>();
		
		Set keySet = new HashSet();
		
		/*
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j <= states; j++)
			{
				
				keySet.
			}
		} */
		
		statMap.put(srcKey, 0);
		
		int z = 0;
		while(!statMap.isEmpty())
		{
			//z++;

			ShopKey  key =  statMap.keySet().iterator().next();
			 //Entry<ShopKey, Integer> entry = statMap.pollFirstEntry(); //statMap.firstEntry();//.getKey();
			 //ShopKey key =  entry.getKey(); //statMap.entrySet().iterator().next().getKey(); //firstEntry().getKey();
			 //ShopKey key = entry.getKey();
			//if (//statMap.)
			//int time = entry.getValue() ;// statMap.get(key);
			 
//			 ////
			 
			 //if (statMap.get(key)==null)
			//	 	break;
			 
			
			int time =  statMap.get(key); //.getValue(); //statMap.get(key);
			 //int time =  entry.getValue(); //statMap.get(key);
			 
			//System.out.println(key.idx+ " === "+time);
			
			int mall = key.idx;
						 			
			int state = key.state; 
												
			statMap.remove(key);
			//statMap.remove(statMap.firstKey());
												
			for (Edge e : malls[mall].edges)  //int i = 0; i < malls[mall].edges.s)
			{
				int to = -1;
				
				if (e.m1.id!=mall)
					to = e.m1.id;
				else
					to = e.m2.id;

				int newState = state | malls[to].fishMask;
				int newTime = time + e.time;
				
				//e.
				
				//String newKey = to + " " + newState;
				
				
				
				if (timeMtx[to][newState] < newTime )
					continue;
				
				ShopKey newKey = new ShopKey();
				newKey.idx = to;
				newKey.state = newState;
				
				//if (!statMap.containsKey(newKey))				
				{
					statMap.put(newKey, newTime );
					timeMtx[to][newState] = newTime;
				}
				/*
				else
				{
					int cacheTime = (Integer) statMap.get(newKey);
					
					if (cacheTime > newTime)
					{
						statMap.put(newKey, newTime);
						timeMtx[to][newState] = newTime;
					}
				} */
					
				
			}
			
		}
		
		
		int ans = Integer.MAX_VALUE;
		
		
		
		for (int i = 1; i <= states; i++ )
		{
			for (int j = 1; j <= states; j++)
			{
				//statMap.get()
				int  state = i | j;
				
				
				if (state == states)
				{

					
					
					int time1 = Integer.MAX_VALUE;
					

					if(timeMtx[n-1][i]!=Integer.MAX_VALUE);
						time1 = timeMtx[n-1][i]; 
					
					int time2 =  Integer.MAX_VALUE;
					if (timeMtx[n-1][j]!=Integer.MAX_VALUE)
						time2 = timeMtx[n-1][j]; 
					
					if (time1 < time2)
						time1 = time2;
					
					if (time1 < ans)
					{
						ans = time1;
					}
				}
				
				
			}
		} 
						
		return ans;
		
		
		 
		
		
	}

	public static void main(String[] args) throws Exception{
		

		Solution sol = new Solution();
		
		System.out.println(sol.calc());

	}

}
