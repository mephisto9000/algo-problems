package problem49;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, Integer> listKeys = new HashMap();
        List<List<String>> ans = new ArrayList();
        
        for (int i=0; i < strs.length; i++)
        {
            char[] ch=strs[i].toCharArray();  
            
            Arrays.sort(ch);
            
            String sorted = new String(ch);
            
            if (!listKeys.containsKey(sorted))
            {
                List<String> l = new LinkedList();
                l.add(strs[i]);
                
                ans.add(l);
                
                listKeys.put(sorted, ans.size() - 1);
            }
            else
            {
                List<String> l =  ans.get(listKeys.get(sorted));
                l.add(strs[i]);
            }
        }
        
        return ans;
        
    }
}