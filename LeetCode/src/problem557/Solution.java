package problem557;

class Solution {
    public String reverseWords(String s) {
        
        StringBuffer sb = new StringBuffer();        
        String[] vals = s.split(" ");
        
        for (int i = 0; i < vals.length; i++)
        {
            StringBuilder reverser = new StringBuilder();
            reverser.append(vals[i]);
            sb.append(reverser.reverse());
            sb.append(" ");
        }
        
        return sb.toString().trim();
        
    }
}