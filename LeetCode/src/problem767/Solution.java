package problem767;

class Solution {
        
    public String reorganizeString(String S) {        
        int cnt[][] = new int[26][2];        
        for (int i = 0; i < S.length(); i++) {
            cnt[S.charAt(i)-'a'][0] = S.charAt(i)-'a';
            cnt[S.charAt(i)-'a'][1] ++;
        }
                                                
        PriorityQueue<int[]> pq = new PriorityQueue(26, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int b[]) {
                return (a[1]==b[1] ? 0 : b[1]-a[1]);
            }
        });      
        
        for (int i = 0; i < 26; i++) {
            if (cnt[i][1]>0)
                pq.add(cnt[i]);
        }
        
        int[] last = pq.poll();
        StringBuffer sb = new StringBuffer();
        sb.append((char)(last[0]+'a'));
        last[1] -- ;
        while(last[1] > 0 || !pq.isEmpty()) {
            
            if (last[1] > 0 && pq.isEmpty())
                return "";
            
            int tmp[] = pq.poll();
            sb.append((char)(tmp[0]+'a'));
            tmp[1]--;
            if (last[1] > 0)
                pq.add(last);
            last = tmp;
            
        }
        
        return sb.toString();
        
       
    }
}