package problem246;

class Solution {
    public boolean isStrobogrammatic(String num) {        
        StringBuffer sb = new StringBuffer();
        for (int i = num.length()-1; i >= 0; i--) {
            int t = num.charAt(i)-'0';
            if (!isAcceptable(t))
                return false;
            switch(t) {
                case 6:
                    sb.append(9);
                    break;
                case 9:
                    sb.append(6);
                    break;
                default:
                    sb.append(t);                
                
            }
        }
        if (num.equals(sb.toString()))
            return true;
        return false;
        
    }
    
    boolean isAcceptable(int c) {
        if (c==6||c==8||c==0||c==9||c==1)
            return true;
        return false;
    }
}