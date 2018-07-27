package problem821;

class Solution {
    
    int[] arr;
    public int[] shortestToChar(String S, char C) {        
        
        List<Integer> l = new ArrayList();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C)
                l.add(i);
        }
        
        arr = new int[l.size()];
        Iterator<Integer> it = l.iterator();
        for (int i = 0; i < l.size(); i++)  {            
            arr[i] = it.next();
        }
            
        int[] ans = new int[S.length()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = bs(i);
        }        
        return ans;                    
    }
    
    int bs(int v) {
        
        int i = 0;
        int j = arr.length-1;
        
        while (i <= j) {
            int m = (i + j) / 2;
            
            if (arr[m] == v)
                return 0;
            if (arr[m] > v) {
                j = m -1;
            }
            else
                i = m +1;            
                
        }
                
        if (i <= 0)
            return arr[0] - v;
        
        int l1 = Math.abs(v - arr[i-1]);
        int l2 = i < arr.length ? Math.abs(arr[i] - v) : Integer.MAX_VALUE;
        return Math.min(l1,l2);
    }
}