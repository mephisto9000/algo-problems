package problem159;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int ans = 0;
        int idx = 0;        
        Map<Character, Integer> map = new HashMap();        
        Deque<Character> dq = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c,i);
            }
            else {
                if (dq.size() == 2) {                    
                    ans = Math.max(i-idx, ans);
                    for (int j = idx; j <i; j++) {
                        char candidate = s.charAt(j);
                        if (map.get(candidate)==j) {
                            dq.remove(candidate);
                            map.remove(candidate);
                            idx = j+1;
                            break;
                        }
                    }                     
                }
                dq.add(c);
                map.put(c,i);
            }
        }
        
        if (!dq.isEmpty())
            ans = Math.max(ans, Math.max(map.get(dq.peekFirst()), map.get(dq.peekLast()))+1 - idx);        
        return ans;
    }
}