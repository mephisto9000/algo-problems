package problem796;

class Solution {
    public boolean rotateString(String A, String B) {
        
        StringBuffer sb = new StringBuffer();
        sb.append(A);
        
        if (A.equals(B))
            return true;
        for (int i = 0; i < A.length(); i++) {
 
            sb.deleteCharAt(0);
            sb.append(A.charAt(i));
            
            if (sb.toString().equals(B))
                return true;
        }
            
        return false;
        
    }
}