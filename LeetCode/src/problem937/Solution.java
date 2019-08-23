package problem937;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
      
      PriorityQueue<String> letterLogs = new PriorityQueue<>(new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
          int idx1 = a.indexOf(' ');
          int idx2 = b.indexOf(' ');
          String s1 = a.substring(idx1+1);
          String s2 = b.substring(idx2+1);
          int noTie = s1.compareTo(s2);
          return (noTie != 0 )? noTie : a.substring(0, idx1).compareTo(b.substring(0, idx2));                    
        }
      });
      Queue<String> digitLogs = new LinkedList();
      for (int i = 0; i < logs.length; i++) {
        if (isLetterLog(logs[i])) {
          letterLogs.add(logs[i]);
        } else {
          digitLogs.add(logs[i]);
        }
      }
      
      String[] ans = new String[logs.length];
      int idx = 0;
      while(!letterLogs.isEmpty()) {
        ans[idx++] = letterLogs.poll();
      }
      while(!digitLogs.isEmpty()) {
        ans[idx++] = digitLogs.poll();
      }
        
      return ans;
    }
  
  boolean isLetterLog(String s) {
    int idx = s.indexOf(' ');
    for (int i = idx+1; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i)))
        return false;      
    }
    return true;
  }
}