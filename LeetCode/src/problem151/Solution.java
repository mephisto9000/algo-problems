package problem151;

public class Solution {
    public String reverseWords(String s) {
        
        String vals[] = s.split(" ");
        StringBuffer sb = new StringBuffer();
        
        for (int i = vals.length-1; i >=0; i--)
        {   
            if (vals[i].trim().equals(""))
                continue;
            sb.append(vals[i]);
            sb.append(" ");
        }
        
        return sb.toString().trim();
        
    }
}