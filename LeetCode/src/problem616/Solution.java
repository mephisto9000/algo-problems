package problem616;

class Solution {
    public String addBoldTag(String s, String[] dict) {
      
      
      List<int[]> intervals = new LinkedList<>();
      for (int i = 0; i < dict.length; i++) {
        intervals.addAll(find(s, dict[i]));
      }
      
      Collections.sort(intervals, new Comparator<int[]>() {
        @Override
        public int compare(int[]a, int[]b) {
          return  (a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        }
      });
      
      int[] pair = null;
      
      List<int[]> ans = new LinkedList<>();
      for (int[]p: intervals) {
        if (pair == null)
          pair = p;        
        else {
          if (p[0]>pair[1]) {            
            ans.add(pair);
            pair = p;
          }
          else
            pair[1] = Math.max(pair[1], p[1]);
        }
          
      }
      ans.add(pair);
      
      Set<Integer> open = new HashSet<>();
      Set<Integer> close = new HashSet<>();
      for (int[]p: ans) {
        if (p!= null) {
          open.add(p[0]);
          close.add(p[1]);
        }
      }
      
      StringBuffer sb = new StringBuffer();
      
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (open.contains(i))
          sb.append("<b>");        
        sb.append(c);
        if (close.contains(i+1))
          sb.append("</b>");
      }
      
      return sb.toString();
    }
  
    List<int[]> find(String s, String target) {
      int len = target.length();
      long prime = 117;
      long alphabet = 26;
      
      List<int[]> ans = new LinkedList<>();
      if (s.length() < len)
        return ans;
      
      long thash = 0;
      long shash = 0;
      long cutPow = 0;
      for (int i = 0; i< len; i++) {
        thash = (thash*alphabet + (target.charAt(i)))%prime;
        shash = (shash*alphabet + (s.charAt(i)))%prime;
        
        if (thash < 0)
          thash += prime;
        if (shash < 0)
          shash += prime;
      }
            
      for (int i = 0; i < len; i++)
            cutPow = i> 0 ? ((cutPow*alphabet)  % prime)  : 1; 

      if (thash == shash && target.equals(s.substring(0,len))) {        
        ans.add(new int[] {0, len});
      }
      
      int z = 0;
      for (int i = len; i <s.length(); i++) {
        long x = s.charAt(i);
        long c = (s.charAt(z)) * cutPow;
        shash = (((shash-c)*alphabet + x) % prime) ;
                        
        if (shash < 0)
          shash += prime;
                
        if (thash == shash && target.equals(s.substring(z+1,i+1))) {        
          ans.add(new int[] {z+1, i+1});    
        }
        z++;
      }      
      return ans;
    }
}