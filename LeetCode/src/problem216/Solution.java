package problem216;

class Solution {
    
    public List<List<Integer>> combinationSum3(int k, int n) {                        
        return rec(0, k, n);               
    }
    
    List<List<Integer>>  rec(int v, int k, int n)
    {
        if (n == 0 && k == 0)
        {
            List<List<Integer>> x = new LinkedList();
            x.add(new LinkedList());
            return x;
        }
        
        if (n < 0 )
            return null;
                
        List<List<Integer>> localAns = new LinkedList();
        for (int i = v + 1; i < 10; i++)
        {
           List<List<Integer>>  tmp = rec(i, k-1, n - i);
            if (tmp != null)
            {
                                 
                for (List<Integer> t : tmp)
                {
                    t.add(i);
                    localAns.add(t);
                } 
                 
            };
        }
        
        
        return localAns;
    }
}