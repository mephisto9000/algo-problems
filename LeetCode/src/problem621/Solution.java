package problem621;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int map[] = new int[26];
        for (char c: tasks)
            map[c-'A'] ++;
        
        PriorityQueue<Integer> pq = new PriorityQueue(26, Collections.reverseOrder());
        
        for (int i = 0; i < 26; i++)
            if (map[i] > 0)
                pq.add(map[i]);
        
        int time = 0;
        while(!pq.isEmpty()) {
            
            List<Integer> list = new LinkedList();
            for (int i = 0; i <= n; i++) {
                
                time ++;
                if (pq.size() > 0) {
                    int next = pq.poll()-1;
                    if (next > 0)
                        list.add(next);
                }
                if (pq.isEmpty() && list.isEmpty())
                    break;
                
            }
            
            for (Integer t : list)
                pq.add(t);
        }
        
        return time;        
        
    }
}