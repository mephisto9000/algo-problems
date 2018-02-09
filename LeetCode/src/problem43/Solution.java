package problem43;

class Solution {
    public String multiply(String num1, String num2) {
        
        String top = null;
        String down = null;
        if (num1.length() > num2.length())
        {
            top = num1;
            down = num2;
        }
        else
        {
            down = num1;
            top = num2;
        }
        
        
        int curry = 0;
        int maxLen = 0;
        
        StringBuffer sb = new StringBuffer();
        
        List<String> tmpSums = new ArrayList();
        for (int i = down.length()-1; i >= 0; i --)
        {
            int di = Character.getNumericValue(down.charAt(i));
            curry = 0;
            sb.setLength(0);
            
            for (int z = 0; z <  down.length() - 1 -i; z++)
                sb.append('0');
            
            for (int j = top.length()-1; j >= 0; j--)
            {
                int ti = Character.getNumericValue(top.charAt(j));
                
                int v = ti * di + curry;
                curry = 0;
                if (v > 9)
                {
                    curry = v/10;
                    v = v % 10;
                }
                sb.insert(0, v);
            }
            
            if (curry > 0)
                sb.insert(0,curry);
            
            if (sb.length() > maxLen)
                maxLen= sb.length();
                
            tmpSums.add(sb.toString());
        }
        
        sb.setLength(0);
        curry = 0;
        for (int i = 0; i < maxLen; i++)
        {
            int v = curry;
            curry = 0;
            for (int j = 0; j < tmpSums.size(); j++)
            {
                String s = tmpSums.get(j);
                
                
               
                int cid = s.length()-1 - i;  
                
                if (cid < 0)
                    continue;
                
                int x = Character.getNumericValue(s.charAt(cid));
                v += x;
            }
            
            if (v > 9)
            {
                curry = v / 10;
                v = v % 10;
            }
            
            
            sb.insert(0,v);
        }
        if (curry > 0)
            sb.insert(0, curry);
        
        while(sb.length() > 1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);         
        
        
        return sb.toString();
        
    }
}
