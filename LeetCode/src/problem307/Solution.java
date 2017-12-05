package problem307;

class NumArray {
    
    int tree[];
    int n;
    
    int nums[];

    public NumArray(int[] nums) {
        
        this.nums = nums;
        n = nums.length;
        tree = new int[4*n];        
        
        createTree(1, 0, n-1);
    }
    
    int createTree(int idx, int from, int to)
    {
        if (from == to)
        {
            tree[idx] = nums[from];
            return tree[idx];
                
        }
        
        if (from > to)
            return 0;
        
        int mid = (from + to)/2;
        
        int v1 = createTree(2*idx, from, mid);
        int v2 = createTree(2*idx + 1, mid+1, to);
        
        tree[idx] = v1 + v2;
        return tree[idx];
        
    }
    
    void updateTree(int idx, int tl, int tr,  int ai, int diff)
    {
        if (tl == tr)
        {
            if (tl == ai)
            {
                tree[idx] += diff;
                nums[ai] += diff;
                
            }
            
            return;
        }
        
        if (tl > ai || tr < ai)
            return ;
        
        int mid = (tl + tr) / 2;
        
        updateTree(idx * 2 , tl, mid, ai, diff);
        updateTree(idx * 2 + 1, mid+ 1, tr, ai, diff);
        
        tree[idx] += diff; 
        
    }
    
    int query(int idx, int tl, int tr, int al, int ar)
    {
        if (tl >= al && tr <= ar)
            return tree[idx];
        
        if (tl > ar || tr < al)
            return 0;
        
        int mid = (tl + tr) / 2;
        
        int v1;
        if (mid == tr)
            mid++;
      
            
            v1 = query(idx * 2, tl, mid, al, ar);
   
        
        int v2;
        
 
            v2 = query(idx *2+1, mid + 1, tr, al, ar);
        
        return v1 + v2;
    }
    
    
    public void update(int i, int val) {
    	
    	int diff = val - nums[i];
        updateTree(1, 0, n-1, i, diff);
    }
    
    public int sumRange(int i, int j) {
    	 
    	return query(1, 0, n-1, i, j);
        
        
    }
}