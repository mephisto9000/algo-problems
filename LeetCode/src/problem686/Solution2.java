package problem686;

class Solution {
    
    public final long BASE = 26;
    public final long PRIME = 1000007;
    public int repeatedStringMatch(String A, String B) {
        
        StringBuffer sb = new StringBuffer();
        
        Set<Character> s = new HashSet();
        for (int i = 0; i < A.length(); i++)
            s.add(A.charAt(i));
        for (int i = 0; i < B.length(); i++)
            if (!s.contains(B.charAt(i)))
                return -1;
        
        while((sb.length() < B.length()*4) || (sb.length() < A.length()*2)) {
            sb.append(A);
        }
        
        String extendedA = sb.toString();
        long bHash = strHash(B, 0, B.length()-1);
        long rollingHash = strHash(extendedA, 0, B.length()-1);
        long cutPow = 1;
        
        for (int i = 0; i < B.length(); i++)
            cutPow = i> 0 ? ((cutPow*BASE)  % PRIME)  : 1; 
            
        if (rollingHash == bHash && extendedA.substring(0, B.length()).equals(B))

            return (int) Math.ceil((B.length()+0.0f)/A.length());
        int z = 0;
        
        
        for (int i = B.length(); i <  extendedA.length(); i++) {
             rollingHash = ((rollingHash -(extendedA.charAt(z)-'a')*cutPow )*BASE + (extendedA.charAt(i)-'a')) % PRIME;
            
            if (rollingHash < 0)
                rollingHash += PRIME;
            
            if (bHash == rollingHash  && extendedA.substring(z+1, i+1).equals(B)) 
            {
                return (int) Math.ceil((i+1.0f)/A.length());                
            }
            z++;
        }
        
        return -1;        
    }
    
    long strHash(String s, int l, int r) {
        long sum = 0;
        for (int i = l; i <= r; i++) {
            sum = (sum*BASE + (s.charAt(i)-'a')) % PRIME;
            
        }
        return sum;
    }
}