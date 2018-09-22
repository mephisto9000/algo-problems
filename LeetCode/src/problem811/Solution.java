package problem811;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < cpdomains.length; i++) {
            
            String s[] = cpdomains[i].split(" ");
            Integer v = Integer.parseInt(s[0]);
            String key = s[1];
            int idx = 0;
             
            s = key.split("\\.");
            StringBuffer sb = new StringBuffer();
            for (int j = s.length-1; j >= 0 ; j--) {
                
                
                if (sb.length() > 0)
                    sb.insert(0,'.');
                sb.insert(0, s[j]);
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+v);
                
            }
        }
        
        List<String> ans = new LinkedList();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            ans.add(pair.getValue() + " "+ pair.getKey());        
        }
        return ans;
        
    }
}