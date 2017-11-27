package problem84;

import java.util.HashMap;
import java.util.Map;



/**
 * 
 * @author mephisto9000
 * Segment tree aproach to solve a problem. NlogN solution is not good enough (
 */
class SolutionSegTree {
    
    int heights[];
     int h;
    
    int minH;
    int n;
    int tree[];
    
    public int largestRectangleArea(int[] heights) {
        
        
        if (heights == null || heights.length==0)
            return 0;
        this.heights = heights;
        n = heights.length;        
        h = 0;
        
        tree = new int[4*n];
                        
        initTree(1, 0, n-1);
         return divConc(0, n-1);
    }
    
    int divConc(int i, int j)
    {
    	
    	if (i > j)
    		return -1;
    	if (i == j)
    		return heights[i];
    	
    	 	
    	
    	int minIdx = getMinFromTree(1, 0, n-1, i, j);
    	
    	if (minIdx > j || minIdx < i)
    		return -1;
    	
    	 
    	
    	int v1 = divConc(i, minIdx-1);
    	int v2 = divConc(minIdx+1, j);
    	
    	int v3 = (j-i +1) * heights[minIdx];
    	
    	int max = v1;
    	if (v2 > max)
    		max = v2;
    	if (v3 > max)
    		max = v3;
    	
    	return max;
    	
    }
    
    int initTree(int idx,  int l, int r)
    {
    	if (l == r)
    	{
    		tree[idx] = l;
    		return tree[idx];
    	}
    	     	
    	int m = l +( r - l) / 2;
    	
    	int v1 = initTree(idx*2,  l, m);
    	int v2 = initTree(idx*2+1, m+1, r);
    	
    	int min = heights[v1]<heights[v2] ? v1: v2;
    	
    	tree[idx] = min;
    	return tree[idx];
    }
    
    int getMinFromTree(int idx, int l, int r, int ql, int qr)
    {
    	if (l >= ql && r <= qr)
    		return tree[idx];
    	
    	 if (l > qr || r < ql)
             return Integer.MAX_VALUE;
    	
    	int m = l +( r - l) / 2;
    	
    	//if ()
    	
    	int v1 = Integer.MAX_VALUE;
    	int v2 = Integer.MAX_VALUE;
    	
    	 
    	
    	if (m < r)
    		v1 = getMinFromTree(idx*2,   l,   m, ql, qr);
    	
    
    	v2 = getMinFromTree(idx*2+1, m+1, r, ql, qr);
    	
    	if(v1 == Integer.MAX_VALUE)
    	{
	    	return v2;
    	}
    	
    	if(v2 == Integer.MAX_VALUE)
    	{
	    	return v1;
    	}
    	
    	
    	return heights[v1]<heights[v2] ? v1: v2;
    }
    
    
}
