package problem422;

class Solution {
    public boolean validWordSquare(List<String> words) {
        
        int n = words.size();
        char[][] mtx = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            String s = words.get(i);
            if (s.length() > n)
                return false;
            
            for (int j = 0; j < s.length(); j++) {
                mtx[i][j] = s.charAt(j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (mtx[i][j]!=mtx[j][i])
                    return false;
        }
        
        return true;
        
    }
}