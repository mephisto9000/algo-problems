package problem22;

class Solution {
    
    
    
    List<String> ans;
    Set<String> unique;
    public List<String> generateParenthesis(int n) {
        
        ans = new LinkedList<String>();
        unique = new HashSet<String>();
        
        generate1(n * 2, "", 0);
        
        Iterator<String> it = unique.iterator();
        
        while(it.hasNext())
        {
            String val = (String) it.next();
            ans.add(val);
        }
        
        
        return ans;
        
    }
    
    void generate1(int n, String prev, int cnt)
    {
    	
    	if (cnt < 0)
    		return ;
    	
        if (n == 0 && cnt == 0)
        {
        	System.out.println(prev);
        	
            unique.add(prev);
            return;
        }
        if (n < 0)
    		return ;
        
        generate1(n-1, prev + '(', cnt + 1);
        generate1(n-1, prev + ')', cnt - 1);
        
        
    }
    
    
}