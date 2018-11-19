package problem227;

class Solution {
    public int calculate(String s) {
        String[] sums = s.split("\\+");
        boolean found = false;
        int val = 0;
        if (sums.length == 1) {
            String[] decs = s.split("-");
            
            if (decs.length == 1) {  
                boolean isMul = true;
                int z = 0;
                for (int i = s.length()-1; i >= 0; i--) {
                    char x = s.charAt(i);
                    if (Character.isDigit(x)) {
                        val = (int)Math.pow(10, z++)*(x-'0') + val;
                        }
                    else {
                        if (x == '*') 
                            return calculate(s.substring(0,i))*val;
                        if (x == '/') 
                            return calculate(s.substring(0, i))/val;
                        }
                    }
                    return val;
                }
            else {
                found = true;
                val = calculate(decs[0]);
                for (int i =1; i < decs.length; i++)  
                    val -= calculate(decs[i]);                
            }
        }
        else {
            found = true;
            for (String sum : sums) {
                val += calculate(sum);
        }
        }
        return val;
    }
}