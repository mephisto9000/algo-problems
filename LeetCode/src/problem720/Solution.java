package problem720;

class Solution {
    public String longestWord(String[] words) {
        
        Arrays.sort(words);
        
        Map<String, Integer> map = new HashMap();
        
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        StringBuffer sb = new StringBuffer();
        String ans = "";
        for (int i =0; i < words.length; i++) {
            sb.setLength(0);
            for (int j = 0; j < words[i].length(); j++) {
                sb.append(words[i].charAt(j));
                if (!map.containsKey(sb.toString())) {
                    sb.setLength(0);
                    break;
                }
            }
            if (sb.length() > ans.length())
                ans = words[i];
            
        }
        
        return ans;
        
    }
}