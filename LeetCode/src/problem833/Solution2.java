package problem833;

class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        
        StringBuffer sb = new StringBuffer();
 
        int i = 0;
        while(i < S.length()) {
            boolean found = false;
            for (int j = 0; j < indexes.length; j++) {
                
                if (i == indexes[j]) {
                    if (S.indexOf(sources[j], i) == i) {
                        found = true;
                        sb.append(targets[j]);
                        i+= sources[j].length();
                        break;
                    }
                }
            }
        
            if (!found)
                sb.append(S.charAt(i++));
        }
        
        return sb.toString();
        
    }
}