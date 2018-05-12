package problem824;

class Solution {
    public String toGoatLatin(String S) {
        
        String[] words = S.split(" ");
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            char c = Character.toLowerCase(words[i].charAt(0));
            
            if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ))
            {
                ans.append(words[i].substring(1));
                ans.append(words[i].substring(0,1));
            }
            else
                ans.append(words[i]);
            
            ans.append("ma");
            for (int j = -1; j < i; j++)
                ans.append('a');
            
            ans.append(" ");
        }
        
        return ans.toString().trim();
        
    }
}