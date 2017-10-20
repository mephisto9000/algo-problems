package problem258;

class Solution {
    public int addDigits(int num) {
        
        if (num < 10)
            return num;       
      
        
        int s = 0;
       
        
       // for (int i = 0; i < len; i++)
        while(num > 0)
        {
            s += num  % 10;
            num /= 10;
        }
        return addDigits(s);       
        
    }
}