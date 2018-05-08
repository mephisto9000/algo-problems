package problem819;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        StringBuffer sb = new StringBuffer();
        
        Set<String> bannedSet = new HashSet();
        Set<String> allowedSet = new HashSet();
        
        for (String b: banned)
            bannedSet.add(b);
        
        Map<String, Integer> wordMap = new HashMap();
        paragraph=paragraph+'.';
        
        List<String> words = new LinkedList();
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(c);
            }
            else {
                if (sb.length() > 0)  {
                    String word = sb.toString().toLowerCase();
                    
                    if (!bannedSet.contains(word)) {
                        allowedSet.add(word);
                        if (wordMap.containsKey(word))
                            wordMap.put(word, wordMap.get(word) + 1);
                        else
                            wordMap.put(word, 1);
                    }
                    sb.setLength(0);
                }
                
                    
            }
            
        }
        
        int max = 0;
        String maxWord = "";
        for (String w : allowedSet) {
            int v = wordMap.get(w);
            if (v > max) {
                max = v;
                maxWord = w;
            }
        }

        return maxWord; 
        
    }
}