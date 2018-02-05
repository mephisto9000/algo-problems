package problem412;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new LinkedList();
        
        for (int i = 1; i <= n; i++ )
        {
            String v = "";
            if (i % 3 == 0)
            {
                v += "Fizz";
            }
            if (i % 5 == 0)
            {
                v+= "Buzz";
            }
            
            if (v.isEmpty())
                v = String.valueOf(i);
            
            
            ans.add(v);
        }
        
        return ans;
        
    }
}