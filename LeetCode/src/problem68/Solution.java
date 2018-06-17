package problem68;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> ans = new LinkedList();
        
        StringBuffer sb = new StringBuffer();
        
        int i = 0;
        int j = 0;
        int len = 0;
        while(true) {
            j = i;
            while(true) {

                if (len > 0)
                    len++;
                if (j < words.length)
                    len+=words[j].length(); 
                else
                    break;
                if (len > maxWidth) {
                    len = 0;
                    break;
                }
                j++;
            }
             if (j  >= words.length) {
                for (int z = i; z < j; z++) {
                    sb.append(words[z]);
                    sb.append(" ");
                }
                if (sb.length() > 0)
                    sb.setLength(sb.length() -1 );
                while(sb.length() < maxWidth)
                    sb.append(" ");
                ans.add(sb.toString());

            }
            else
            if (j == i + 1) {
                sb.append(words[j-1]);
                while(sb.length()< maxWidth)
                    sb.append(" ");

                ans.add(sb.toString());
                sb.setLength(0);
            }
           
            else {

                int wlen = 0;
                for (int z = i; z < j; z++)
                    if (z < words.length)
                        wlen += words[z].length();
                
                int div = (maxWidth - wlen) / (j - i - 1);
                
                int dif = 0;
                dif = (maxWidth - wlen) - (div * (j - i - 1));
                     
                for (int z = i; z  <j; z++) {
                    if (z < words.length)
                        sb.append(words[z]);
                    if (z < j-1) {
                        for (int x = 0; x < div; x++) {
                            sb.append(" ");
                            if (dif > 0) {
                                sb.append(" ");
                                dif --;
                            }
                        }
                    }
                }
                
                ans.add(sb.toString());
                sb.setLength(0);
                
            }
                
            
            i = j;
            if (i >= words.length)
                break;
        }
        return ans;
        
    }
}