package problem657;

class Solution {
    public boolean judgeCircle(String moves) {
        int i = 0;
        int j = 0;
        
        for (int z = 0; z < moves.length(); z++) {
            char c = moves.charAt(z);
            
            switch (c) {
                case 'U':
                    i--;
                    break;
                case 'D' :
                    i++;
                    break;
                case 'L':
                    j--;
                    break;
                case 'R':
                    j++;
                    break;                    
            }            
        }
        if (i == 0 && j == 0)
            return true;
        return false;
            
    }
}