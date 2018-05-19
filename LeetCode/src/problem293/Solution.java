package problem293;

class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        
        List<String> ans = new LinkedList();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == '+' && s.charAt(i) == '+')
                ans.add(s.substring(0, i-1) + "--" + s.substring(i+1, s.length()));
        }
        
        return ans;
        
    }
}