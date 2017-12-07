package problem279;

class Solution {
    
    List<Integer> squareList;
    int n;
    int len;
    int memo[];
    
    
    public int numSquares(int n) {
        
        this.n = n;
        squareList = new ArrayList();
        
        for (int i = 1; i * i <= n; i++)
        {
            squareList.add(i*i);
        }
        
        len = squareList.size();
        memo = new int[n+1];
        Arrays.fill(memo,-1);
       
        return rec(n);  
    }
    
    int rec(int sum)
    {        
        if (sum == 0)
            return 0;
        
        if (sum < 0) 
            return 100000;
        
        if (memo[sum] != -1 )
            return memo[sum];
         
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < len; i++)
        {
            int v= squareList.get(i);
            int lmin = 1 + rec(sum - v);
            
            if (lmin < min)
                min = lmin;
                
        }
        
        memo[sum] = min;
        
        
        return memo[sum];
        
    }
    
    
}