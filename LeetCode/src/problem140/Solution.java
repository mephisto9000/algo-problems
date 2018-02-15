package problem140;

class Solution {
    
    
    Set<String> wordSet;
    String str;
    int n;
    
    Map<Integer, List<String>> map;
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet();
        str = s;
        n = str.length();
        for (String strTmp: wordDict)
        {
            wordSet.add(strTmp);
        }
        
        map = new HashMap();
        return rec(0);
        
        
        
    }
    
    List<String> rec(int idx)
    {
        if (map.containsKey(idx))
            return map.get(idx);
        
        List<String> ans = new LinkedList();
        if (idx >= n)
        {            
            ans.add("");
            return ans;
        }
        
        for (int i = idx+1; i <=n; i++ )
        {
            String v = str.substring(idx, i);
            
            if (wordSet.contains(v))
            {
                List<String> nextList = rec(idx + v.length());
                
                for (String nextStr: nextList)
                {
                    if (nextStr.length() > 0)
                        ans.add(v+" "+nextStr);
                    else
                        ans.add(v);
                }
            }
            
            
        }
        
        map.put(idx, ans);
        return ans;                
    }
}