package problem6;

class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1)
            return s;
        
        StringBuffer sb[] = new StringBuffer[numRows];
        
        for (int i = 0; i < numRows; i++)
            sb[i] = new StringBuffer();
        
        boolean down = true;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb[idx].append(c);
            if (down)
                idx++;
            else
                idx--;
            
            if (idx == numRows) {
                idx-=2;
                down = false;
            } else
            if (idx == -1) {
                idx+=2;
                down = true;
            }
        }
        
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < numRows;i++)
            ans.append(sb[i].toString());
        return ans.toString();
        
    }
}