package problem735;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> s = new Stack();
        
        for (int i = 0; i < asteroids.length; i++)
        {
            int ast = asteroids[i];
            while(ast != 0)
            {                
                
                 if (s.isEmpty() || Math.signum(s.peek()) == Math.signum(ast) || (s.peek() < 0 && ast > 0))
                {
                    s.push(ast);
                    break;
                }
                else            
                {
                    int top = s.pop();                
                    //ast = Math.max(top + ast;
                    if (top + ast == 0)
                    {
                        ast = 0;
                        continue;
                    }
                    else
                    if (Math.max(Math.abs(top), Math.abs(ast)) == Math.abs(top))
                    {
                        ast = top;
                    }
                }
            }
        }
        
        List<Integer> l = new ArrayList(s);
        int ans[] = new int[l.size()];
        for (int i = 0; i < ans.length; i++)
            ans[i] = l.get(i);
        
        return ans;
        
    }
}