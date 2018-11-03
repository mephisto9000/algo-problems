package problem640;

class Solution {
    public String solveEquation(String equation) {
        
        int xfact = 0;
        int coefficient=0;
        int lastSign=1;
        int tmp = Integer.MAX_VALUE;
        boolean left = true;
        for(int i = 0; i < equation.length(); i++) {
           
           char c = equation.charAt(i) ; 
                       
           if (c=='=') {
               
               if (tmp == Integer.MAX_VALUE)
                   tmp = 0;
               
               coefficient+= tmp*(left?-1:1)*lastSign;
               tmp = Integer.MAX_VALUE;
               left=false;
               lastSign=1;
           } else            
            if (isDigit(c)) {
                int inc = c - '0';
                if (tmp == Integer.MAX_VALUE)
                    tmp = 0;
                tmp = tmp*10+inc;
            } else
            {                
                
                if (isSign(c)) {
                    
                    if (tmp == Integer.MAX_VALUE)
                        tmp = 0;
                    
                    coefficient+= tmp*(left?-1:1)*lastSign;
                    tmp = Integer.MAX_VALUE;
                    if (c=='+')
                        lastSign = 1;
                    else
                        lastSign=-1;
                }
                else {
                    if (tmp == 0)
                        continue;
                    if (tmp == Integer.MAX_VALUE)
                        tmp = 1;
                    xfact += tmp*(left?1:-1)*lastSign;
                    tmp = Integer.MAX_VALUE;
                }
            }
            
            
            
        }
        
        
        if (tmp!= 0 && tmp != Integer.MAX_VALUE)
             coefficient+= tmp*(left?-1:1)*lastSign;
                
        if (xfact==0 ) {
            if (coefficient == 0)
                return "Infinite solutions";
            else
                return "No solution";            
        }
        
        return "x="+(coefficient / xfact);
        
    }
    
    boolean isDigit(char c) {
        if (c>='0' && c <='9')
            return true;
        return false;
    }
    
    boolean isSign(char c) {
        if (c == '-' || c == '+')
            return true;
        return false;
    }
    
    
    
}