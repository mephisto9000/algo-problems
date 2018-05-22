package problem500;

class Solution {
    public String[] findWords(String[] words) {
        Map<Character, Integer> m = new HashMap();        
        
        m.put('q',1);
        m.put('w',1);
        m.put('e',1);
        m.put('r',1);
        m.put('t',1);
        m.put('y',1);
        m.put('u',1);
        m.put('i',1);
        m.put('o',1);
        m.put('p',1);
        
        m.put('a',2);
        m.put('s',2);
        m.put('d',2);
        m.put('f',2);
        m.put('g',2);
        m.put('h',2);
        m.put('j',2);
        m.put('k',2);
        m.put('l',2);
        
        m.put('z',3);
        m.put('x',3);
        m.put('c',3);
        m.put('v',3);
        m.put('b',3);
        m.put('n',3);
        m.put('m',3);  
        List<String> ans = new LinkedList();
        
        Set<Integer> u = new HashSet();
        for (String w : words) {
            String w1 = w.toLowerCase();
            u.clear();
            
            for (int i = 0; i < w1.length(); i++) {
                char c = w1.charAt(i);
                u.add(m.get(c));
            }
            
            if (u.size() == 1)
                ans.add(w);
            
        }
        
        String[] ansArr = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            ansArr[i] = ans.get(i);
        
        
        return ansArr;
        
    }
}