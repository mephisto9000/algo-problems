package problem884;

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        
        Map<String, Integer> awords = new HashMap();
        String[] aw = A.split(" ");
        for (int i = 0; i < aw.length; i++) {
            int c = awords.getOrDefault(aw[i],0);
            awords.put(aw[i], ++c);
        }
        
        String[] bw = B.split(" ");
        Map<String, Integer> bwords = new HashMap();
        for (int i = 0; i < bw.length; i++) {
            int c = bwords.getOrDefault(bw[i],0);
            bwords.put(bw[i], ++c);
        }
        
        List<String> al = new LinkedList();                
        for (Map.Entry<String,Integer> entry : awords.entrySet())              
            if (entry.getValue() == 1 && !bwords.containsKey(entry.getKey()))
                al.add(entry.getKey());
        
        for (Map.Entry<String,Integer> entry : bwords.entrySet())
            if (entry.getValue() == 1 && !awords.containsKey(entry.getKey()))
                al.add(entry.getKey());
                
        String[] ans = new String[al.size()];
        ans = al.toArray(ans);
        return ans;
        
    }
}