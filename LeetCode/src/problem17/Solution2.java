package problem17;

class Solution {
    
    Map<Character, List<Character>> map = new HashMap();
    List<String> ans = new LinkedList();
    StringBuffer sb = new StringBuffer();
    String digits;
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length()==0)
            return ans;
        this.digits = digits;
        map.put('2', new LinkedList<>(Arrays.asList('a','b','c')));
        map.put('3', new LinkedList<>(Arrays.asList('d','e','f')));
        map.put('4', new LinkedList<>(Arrays.asList('g','h','i')));
        map.put('5', new LinkedList<>(Arrays.asList('j','k','l')));
        map.put('6', new LinkedList<>(Arrays.asList('m','n','o')));
        map.put('7', new LinkedList<>(Arrays.asList('p','q','r','s')));
        map.put('8', new LinkedList<>(Arrays.asList('t','u', 'v')));
        map.put('9', new LinkedList<>(Arrays.asList('w','x', 'y', 'z')));
        
        rec(0);
        return ans;
    }
    
    void rec(int idx) {
        if (idx == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        
        List<Character> arr = map.get(digits.charAt(idx));
        for (char c: arr) {
            sb.append(c);        
            rec(idx+1);
            sb.setLength(sb.length()-1);
        }
    }
}