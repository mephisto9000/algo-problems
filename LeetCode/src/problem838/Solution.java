package problem838;

class Solution {
    public String pushDominoes(String dominoes) {
         
        TreeSet<Integer> ls = new TreeSet();
        TreeSet<Integer> rs = new TreeSet();
        
        for (int i  =0; i < dominoes.length(); i++) {
            char c = dominoes.charAt(i);
            if (c == 'L')
                ls.add(i);
            if (c == 'R')
                rs.add(i);
        }
            
        char[] arr = dominoes.toCharArray();
        
        for (int i = 0; i < dominoes.length(); i++) {
            char c = arr[i];
            if (c == '.') {
                Integer lidx = ls.higher(i);
                Integer ridx = rs.lower(i);
 
                int ldist = 500000;
                int rdist = 500000;
                    
                if (lidx != null)
                    ldist = lidx - i;
                
                if (ldist < 0 || (lidx != null && rs.higher(i) != null && rs.higher(i) < lidx))
                    ldist = 500000;
                
                if (ridx != null)
                    rdist = i - ridx;
                if (rdist < 0 || (ridx!= null && ls.lower(i) != null && ls.lower(i) > ridx))
                    rdist = 500000;
                                                
                if (ldist == rdist) 
                    continue;
                
                                
                if (ldist < rdist)
                    arr[i] = 'L';
                else
                    arr[i] = 'R';
                                 
            }
                        
        }
        
        return String.valueOf(arr);
        
    }
}