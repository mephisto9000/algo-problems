package problem415;

class Solution {
    public String addStrings(String num1, String num2) {
                        
        num1 = reverse(num1);
        num2 = reverse(num2);
        
        int rem = 0;
        int idx = 0;
        
        StringBuffer sb = new StringBuffer();
        while(true)
        {
            
            if (idx >= num1.length() && idx >= num2.length())
                break; 
            
            int n1 = 0;
            int n2 = 0;
            
            if (num1.length() > idx)
            {
                n1 = num1.charAt(idx) - '0';
            }
            
            if (num2.length() > idx)
            {
                n2 = num2.charAt(idx) - '0';
            }
            
            rem += n1 + n2;
            sb.append(rem % 10);
            rem = rem / 10;
            idx ++;
            
            
        }
        if (rem > 0)
            sb.append(rem);
        
        
        return reverse(sb.toString());
        
    }
    
    String reverse(String s)
    {
        StringBuilder input = new StringBuilder();
        input.append(s);
        return input.reverse().toString();
    }
}