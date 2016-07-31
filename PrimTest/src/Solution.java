import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	
	int n; // число вершин в доле 1
	int k; // число вершин в доле 2
	
	boolean[] used;
	List[] g; // списки ребер из вершины i первой доли
	
	List<Integer> mt; // maximum matching (максимальное паросочетание)
	// номер вершины в доле 2, связанный с вершиной i в доле 1 (если -1 то связи нет)

	public void calc() throws Exception
	{
		
	
		int k = 7;
		int n = 7;
		
		g = new ArrayList[n];
		
		g[0] = new ArrayList();
		g[0].add(1);
		
		g[1] = new ArrayList();
		g[1].add(0);
		g[1].add(2);
		
		g[2] = new ArrayList();
		g[2].add(1);
		g[2].add(3);
		g[2].add(5);
		
		g[3] = new ArrayList();
		g[3].add(2);
		g[3].add(4);
		
		g[4] = new ArrayList();
		g[4].add(3);
		
		g[5] = new ArrayList();
		g[5].add(2);
		g[5].add(6);
		
		g[6] = new ArrayList();
		g[6].add(5);
		
		
		mt = new ArrayList<Integer>();				
		for (int i = 0; i < k; i++)
			mt.add(-1);
		
		used = new boolean[n];		
		Arrays.fill(used, false);
		
		int result = 0;
		
		for (int v = 0; v < n; ++v)
		{
			used[v] = false;
			Arrays.fill(used, false);
			
			if (try_kuhn(v))
				result ++;
		}
		
		
		System.out.println("result == "+result);
		
		for (int i = 0; i< n; ++i)
			if (mt.get(i) != -1)
				System.out.println(String.format("%d %d", mt.get(i), i));
				
	}
	
	boolean try_kuhn(int v) {
		
		if (used[v]) 
			return false;
		
		used[v] = true;
		
		for (int i = 0; i < g[v].size(); ++i)
		{
			int to = (int) g[v].get(i);
			
			int dest = mt.get(to);
			
			if (dest== -1 || try_kuhn (dest)) {
				mt.set(to, v);
				return true;
			}
		}
		
		return false;
			
	}
	
	
	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		
		sol.calc();
	}

}
