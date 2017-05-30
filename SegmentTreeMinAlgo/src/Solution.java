import java.util.Arrays;

public class Solution {
	
	
	public class SegmentTree
	{
		int[] tree;
		int[] a;
		int n;
		
		SegmentTree(int[] arr)
		{
			this.n = arr.length;
			a = arr;//new int[n];
			tree = new int[4*n];
			//Arrays.fill(tree, Integer.MAX_VALUE);
		}
		
		
		void build_tree(int v, int tl, int tr)
		{
			if (tl == tr)
				tree[v] = a[tl];
			else
			{
				int tm = (tl + tr) / 2;
				build_tree(v*2, tl, tm);
				build_tree(v*2 + 1, tm+1, tr);
				tree[v] = min(tree[v*2], tree[v*2+1]);
			}
		}
		
		int get_min(int l, int r, int v, int tl, int tr)
		{
			if (l <= tl && tr <= r)			
				return tree[v];
			
			if (tr < l || r < tl)
				return Integer.MAX_VALUE;
			
			int tm = (tl + tr) / 2;
			
			return min(get_min(l,r, v*2, tl, tm), get_min(l,r,v*2+1, tm+1, tr));
			
		}
		
		void update(int idx, int val, int v, int tl, int tr)
		{
			if (idx <= tl && tr <= idx) {
				a[idx] = val;
				tree[v] = val;
				return;
			}
			
			if (tr < idx || idx < tl)
				return;
			
			int tm = (tl + tr)/2;
			
			update(idx, val, v*2, tl, tm);
			update(idx, val, v*2+1, tm+1, tr);
			
			tree[v] = min(tree[v*2], tree[v*2 + 1]);
		}
		
		int min(int a, int b)
		{
			if (a < b)
				return a;
			else
				return b;
		}
	}
	

	public static void main(String[] args) {
		int arr[] = {5,10,1,100,9,11};
		int n = arr.length;
		
		Solution sol = new Solution();
		SegmentTree st = sol.new SegmentTree(arr);
		
		st.build_tree(1, 0, n-1);
		
		System.out.println(st.get_min(3, 4, 1, 0, n-1));

	}

}
