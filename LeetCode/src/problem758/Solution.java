package problem758;

class Solution {
    public String boldWords(String[] words, String S) {
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (a[0] != b[0] ? a[0]-b[0] : b[1] - b[0]);

            }
        } );                         
        for (String word : words) {
            int idx = 0;
            while(true) {
                idx = S.indexOf(word, idx);
                if (idx == -1)
                    break;                
                int eidx = idx + word.length();
                pq.add(new int[] {idx, eidx});
                idx = idx+1;                
            }            
        }
        
        Deque<int[]> intervals = new LinkedList();
        while(pq.size() > 0) {
            if (intervals.size() == 0) 
                intervals.add(pq.poll());                
            if (pq.size() > 0) {
            if ( intervals.getLast()[1] < pq.peek()[0])
                intervals.add(pq.poll());
            else {
                intervals.getLast()[1] = Math.max(pq.poll()[1],intervals.peekLast()[1]);
            }
            }
        }            
        int strIdx = 0;        
        StringBuffer sb = new StringBuffer();
        int open = 0;
        while(strIdx < S.length()) {            
            if (intervals.size() > 0 && strIdx == intervals.getFirst()[0]) {
                sb.append("<b>");
            }            
            if (intervals.size() > 0 && strIdx == intervals.getFirst()[1]) {
                sb.append("</b>");
                intervals.removeFirst();
            }                                   
            sb.append(S.charAt(strIdx++));            
        }        
        if (intervals.size()>0)
            sb.append("</b>");            
        return sb.toString();        
    }
}