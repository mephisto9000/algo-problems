//package vodostoki1015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	String src = null;
	
	int[][] mtx ;
	
	MstNode[][] mst;
	
	int n;
	int m;
	
	class MstNode
	{
		MstNode parent = null;
		
		boolean isTerminal = true;
		
		int x;
		int y;
		
		public MstNode(int x, int y)
		{
			this.x = x;
			this.y = y;
			
			parent = null;
			
		}
		
		public void setParent(MstNode parent)
		{
			this.parent = parent;
		}
		
		public void setNonTerminal()
		{
			isTerminal = false;
		}
	}
	
	MstNode find(MstNode node)
	{
		//MstNode node = mst[ax][ay];
		
		if (node.parent == null)
			return node;
		else
			return (find(node.parent ));
	}
	
	void union(MstNode a, MstNode b)
	{
		MstNode ap = find(a);
		MstNode bp = find(b);
		
		if (ap != bp)
			ap.setParent(bp);
	}
	
	void init_mst()
	{
		mst = new MstNode[n][m];
		
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
			{
				mst[i][j] = new MstNode(i,j);
			}
	}
	
	public int calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		String[] vals = br.readLine().split(" ");
		
		n = Integer.parseInt(vals[0]);
		m = Integer.parseInt(vals[1]);
		
		mtx = new int [n][m];
		
		for (int i = 0; i < n; i++)
		{
			vals = br.readLine().split(" ");
			
			for (int j = 0; j < m; j++)
			{
				mtx[i][j] = Integer.parseInt(vals[j]);
			}
		}
		
		init_mst();
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
			{
				
				if (i > 0 &&  mtx[i-1][j] == mtx[i][j])
					union(mst[i][j], mst[i-1][j]);
				
				if (i < n-1 &&  mtx[i+1][j] == mtx[i][j])
					union(mst[i][j], mst[i+1][j]);
				
				if (j > 0 &&  mtx[i][j-1] == mtx[i][j])
					union(mst[i][j], mst[i][j-1]);
				
				if (j < m-1 &&  mtx[i][j+1] == mtx[i][j])
					union(mst[i][j], mst[i][j+1]);
				
				
				if (i > 0 &&  mtx[i-1][j] < mtx[i][j])
					find(mst[i][j]).setNonTerminal();
				else
				if (i < n-1 &&  mtx[i+1][j] < mtx[i][j])
					find(mst[i][j]).setNonTerminal();
				else
				if (j > 0 &&  mtx[i][j-1] < mtx[i][j])
					find(mst[i][j]).setNonTerminal();
				else
				if (j < m-1 &&  mtx[i][j+1] < mtx[i][j])
					find(mst[i][j]).setNonTerminal();
				
				
			}
		
		
		int res = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
			{
				MstNode node = mst[i][j];
				
				if (node.parent == null && node.isTerminal)
					res++;
			}
			
		
		
		
	
		return res;
		
	}

	public static void main(String[] args) throws Exception {
		Solution sol = new Solution();
		
		System.out.println(sol.calc());

	}

}
