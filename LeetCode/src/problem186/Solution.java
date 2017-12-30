package problem186;

class Solution {
    public void reverseWords(char[] str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; i++)
            sb.append(str[i]);
        
        String[] ans = sb.toString().split(" ");
        
        sb = new StringBuffer();
        for (int i = ans.length-1; i >= 0; i--)
        {
            sb.append(ans[i]);
            sb.append(' ');
        };
        
        String s = sb.toString().trim();
        
        for (int i = 0; i < s.length(); i++)
            str[i] = s.charAt(i);
        
    }
}