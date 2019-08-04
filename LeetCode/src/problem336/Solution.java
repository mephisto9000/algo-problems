package problem336;

class Solution {
    
    Map<String, List<Integer>> wordToIdx;
    List<List<Integer>> checkWord(String w, int idx) {
        
        List<List<Integer>> ans = new LinkedList();
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < w.length(); i++) {
            int v = w.charAt(i) - 'a';
                        
             if (wordToIdx.containsKey(reverse(w.substring(i+1)))) {
                    if (isPoly(w.substring(0, i+1))) {
                        
                        List<Integer> wl = wordToIdx.get(reverse(w.substring(i+1)));
                        processList(wl, ans, idx, true);
                    }
            } 
            
            if (wordToIdx.containsKey(reverse(w.substring(0, i+1)))) {
                if (isPoly(w.substring(i+1))) {
                    List<Integer> wl = wordToIdx.get(reverse(w.substring(0, i+1)));
                        processList(wl, ans, idx, false);
                }
            }
        }
               
        if (w.isEmpty()) {
            for (String s : wordToIdx.keySet()) {
                if (isPoly(s)) {
                    List<Integer> wl = wordToIdx.get(s);
                        processList(wl, ans, idx, true);
                }
            }
        }
        
        return ans;
    }
    
    void processList(List<Integer> wl, List<List<Integer>> ans, int idx, boolean flag) {
        if (wl != null) {
            for (Integer startIdx: wl) {
                if (idx == startIdx) {
                    continue;
                }
                
                List<Integer> pair = new ArrayList<>(
                    (flag)?Arrays.asList(startIdx, idx):Arrays.asList(idx, startIdx));
                ans.add(pair);
            }
        }
        
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        
        wordToIdx = new HashMap<>();
                                
        for (int i = 0; i < words.length; i++) {            
            List<Integer> wl = wordToIdx.getOrDefault(words[i], new ArrayList<>());            
            wl.add(i);
            wordToIdx.put(words[i], wl);
        }
        List<List<Integer>> ans = new LinkedList();
        for (int i = 0; i < words.length; i++) {
            ans.addAll(checkWord(words[i], i));
        }
        return ans;
        
    }
    
    
    boolean isPoly(String s) {
        
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if (s.charAt(i++)!=s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
    
    String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        return sb.reverse().toString();
    }
}