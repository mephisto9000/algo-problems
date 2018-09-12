package problem686;

class Solution {
    public int repeatedStringMatch(String A, String B) {
        
        StringBuffer sb = new StringBuffer();
        int c = 0;
        
        Set<Character> s = new HashSet();
        for (int i = 0; i < A.length(); i++)
            s.add(A.charAt(i));
        for (int i = 0; i < B.length(); i++)
            if (!s.contains(B.charAt(i)))
                return -1;
        
        while(sb.length() < 20000) {
            sb.append(A);
            c++;
            
            if (sb.length() >= B.length() && sb.toString().indexOf(B) >= 0)
                return c;
        }
        
        return -1;        
    }
}