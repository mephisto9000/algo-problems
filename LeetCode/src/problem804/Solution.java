package problem804;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String dict[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> uniques = new HashSet();
        for (int i = 0; i < words.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < words[i].length(); j++) {
                String dec = dict[words[i].charAt(j)-'a'];
                sb.append(dec);
                
            }
            uniques.add(sb.toString());
        }
        return uniques.size();
        
    }
}