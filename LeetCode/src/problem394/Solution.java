package problem394;

class Solution {
    
    
    public String decodeString(String s) {        
       
        StringBuffer ans = new StringBuffer();
        
        int n = s.length();
        int multiplier = -1;
        for (int i = 0; i < n; i++)
        {
            char c = s.charAt(i);
            
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
            {                
                ans.append(c);
            }
            
            if (c >= '0'  && c <= '9')
            {                
                if (multiplier == -1)
                    multiplier = Character.getNumericValue(c);
                else
                    multiplier = 10*multiplier + Character.getNumericValue(c);
            }
            if (c == '[')
                {
 
                    int cnt = 0;
                    int stop = -1;
                    for (int j = i+1; j < n; j++)
                    {
                        char c1 = s.charAt(j);
                        if (c1 == ']')
                        {
                            if (cnt == 0)    
                            {
                               stop = j ;
                                break;
                            }
                            else
                                cnt --;
                        }
                        if (c1 == '[')
                            cnt ++;
                    }
                    
                    String tmp = decodeString(s.substring(i+1, stop));
                    for (int j = 0; j < multiplier; j++)
                    {
                        ans.append(tmp);
                    }
                    multiplier = -1;
                
                i = stop;
                }
        }
        
        return ans.toString();
        
        
        
    }
}