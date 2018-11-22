package problem916;

class Solution {
    
    int bcnt[];
    
    public List<String> wordSubsets(String[] A, String[] B) {
      
        bcnt = new int[26];
        int btmp[] = new int[26];
        for (int i = 0; i < B.length; i++) {
            Arrays.fill(btmp, 0);
            for (int j = 0; j < B[i].length(); j++) {
                int idx = B[i].charAt(j)-'a';
                btmp[idx]++;
            }
            
            for (int j = 0; j < 26; j++) {
                bcnt[j] = Math.max(btmp[j], bcnt[j]);
            }
        }
        
        List<String> ans = new LinkedList();
        for (int i = 0; i < A.length; i++) {
            Arrays.fill(btmp, 0);
            for (int j =0; j < A[i].length(); j++) {
                int idx = A[i].charAt(j)-'a';                
                btmp[idx]++;
            }
            
            boolean ok = true;
            for (int j = 0; j < 26; j++) {
                if (btmp[j] < bcnt[j])
                    ok = false;
            }
            
            if (ok)
                ans.add(A[i]);
        }
        
        return ans;
    }
}