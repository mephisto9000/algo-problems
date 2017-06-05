package D;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	
	public class Cylinder implements Comparable
	{
		int idx;
		int r;
		int h;
		
		long volume = 0;
		
		public void setVolume(long volume)
		{
			this.volume = volume;
		}
		
		public Cylinder(int idx, int r, int h)
		{
			this.idx = idx;
			this.r = r;
			this.h = h;
			
			this.volume = (long)r * (long)r * (long)h;
		}
		
		public long volume()
		{
			return volume;
		}

		@Override
		public int compareTo(Object o) {
			
			Cylinder other = (Cylinder) o;
			
			if (other.volume() > this.volume())
				return -1;
			
			if (other.volume() < this.volume())
				return 1;
			
			
			return 0;
		}
	}
	
	
	
	Cylinder[] arr;
	long[] tree;
	int n;
	
	
	// max gegment tree
	void buildTree(int n)
	{
		this.n = n;
		
		tree = new long[4*n + 1];
		//tree = new long[Integer.highestOneBit(n) << 5];
		
		Arrays.fill(tree, 0);
		
	}
	
	public void update( int v, int idx, int tl, int tr)
	{
		//if (tl > tr)
		
		
		System.out.println("update v =="+v+" idx = "+idx + " tl = "+tl + " tr = "+tr);// + " m = "+m);
		
		
		if (idx < tl || idx > tr)
			return ;
		
		if (tl == tr)			
		{
			if (tl == idx)
			{
				
				System.out.println("i'm here !!!!");
				System.out.println(" idx == "+idx + " vol == "+arr[idx].volume());
				
				tree[v] = arr[idx].volume();
				return;
			}
			else
				return;
		}
		
		int m = (tl + tr) / 2;
		
		// System.out.println(" m = "+m);
		
		
		
		if ( idx <= m)
			update(  v*2 , idx, tl, m);
		else
			update(  v*2 +1, idx, m+1, tr);
		
		tree[v] = max(tree[v*2], tree[v*2+1]);
		
	}
	
	public int getIdx(int v, int idx, int tl, int tr)
	{
		
		if (idx < tl || idx > tr)
			return 0;
		
		if (tl == tr)  
			return v;
		
		int m = (tl + tr) / 2;
		
		return getIdx(  v*2, idx, tl, m) + getIdx(  v*2 + 1, idx, m+1, tr);
		
	}
	
	
	public long getMax(int l, int r, int v, int tl, int tr)
	{
		 
		if (l > tr || r < tl)
			return 0;
		
		//System.out.println("l == "+l + " r=="+r+" v=="+v+" tl=="+tl+" tr=="+tr);
		
		//if (l == r)
		if (l <= tl  && tr <=  r)
		//if (l == tl && r == tr)
			return tree[v];
		
		int m = (tl + tr) / 2;
		
		return max(getMax(l, r, v *2, tl, m), getMax(l, r, v*2+1, m+1, tr));
		
	}
	
	public long max(long a, long b)
	{
		if (a > b)
			return a;
		else
			return b;
	}
	
	
	

	String src = null;
	
	public double calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		
		int n = Integer.parseInt(br.readLine());
		
		
		buildTree(n);
		
		arr = new Cylinder[n];
		
		for (int i = 0; i < n; i++)
		{
			String[] vals = br.readLine().split(" ");
			
			int r = Integer.parseInt(vals[0]);
			int h = Integer.parseInt(vals[1]);
			
			Cylinder cyl = new Cylinder(i, r, h);

			arr[i] = cyl;
		}
		
		Arrays.sort(arr);
		
		//actual calculations
		tree[0] = arr[0].volume();
		
		long maxes[] = new long[n];
		Arrays.fill(maxes, 0);
		
		maxes[0] = arr[0].volume();
		
		
		//System.out.println(arr[0].volume());
		
		
		update(1, 0, 0, n-1);
		
		 
		for (int i = 0; i < n; i++)
		{
			System.out.println(arr[i].volume());
		}
		
		for (int i = 1; i < n; i++)
		{
			
			int idx = arr[i].idx;
			
			 
			//idx-1
			long max =getMax(0,  idx-1, 1, 0, n-1);
			
			
			System.out.println("i == "+i);
			
			
			for (int j = 0; j < 4*n; j++)
			{
				System.out.print(tree[j]+ " ");
			}
			System.out.println();
			
			System.out.println("max == "+max+" idx == " + idx + " vol =="+arr[i].volume());
			
			if (max < arr[i].volume())
			{
				
				maxes[i] = max + arr[i].volume();

				arr[i].setVolume(maxes[i]);
				
				System.out.println("here max = "+maxes[i] + " vol i= "+arr[i].volume() + " idx=="+idx);
												
				//public void update( int v, int idx, int tl, int tr)
				update(1, i, 0, n-1);
				
			}
			else
			{
				//int tree_idx = getIdx(1, idx, 0, n-1);
				
				//tree[tree_idx] = max + arr[i].volume();
				//maxes[i] =   arr[i].volume();
								
				
				//public void update( int v, int idx, int tl, int tr)
				//update(1, idx, 0, n-1);
			}
			
			//tree[i] =  
						
		}
		
		long ans = 0;
		for (int i = 0; i < n; i++)
		{
			
			//System.out.println((Math.PI * maxes[i]));
			
			if (maxes[i] > ans)
				ans = maxes[i];
		}
		
		return Math.PI * ans;
		
		
		//return 0;
	}
	public static void main(String[] args) throws Exception{
		

		Solution sol = new Solution();
		
		double d = sol.calc();
		
		System.out.println(d);
		
		
		

	}

}
