package problem833;

class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        
        StringBuffer sb = new StringBuffer();
        
        Map<Integer, String> targetMap = new HashMap();
        Map<Integer, String> srcMap = new HashMap();
        Set<Integer> idxSet = new HashSet();
        
        for (int i = 0; i < indexes.length; i++) {
            idxSet.add(indexes[i]);
            srcMap.put(indexes[i], sources[i]);
            targetMap.put(indexes[i], targets[i]);
        }
        
        int i = 0;
        while(i < S.length()) {            
            if (idxSet.contains(i)) {
                int j = i;
                StringBuffer tmp = new StringBuffer();
                String src = srcMap.get(i);
                String target = targetMap.get(i);
                while(j < S.length() && tmp.length() < src.length()) {
                    tmp.append(S.charAt(j++));
                 
                }
                
                if (tmp.toString().equals(src)) {
                    sb.append(target);
                    i = j;
                } else
                   sb.append(S.charAt(i++)); 
                
            } else
                sb.append(S.charAt(i++));            
                            
        }
        
        return sb.toString();
    }
}