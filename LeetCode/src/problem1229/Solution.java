package problem1229;

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {        
        int idx1 = 0;
        int idx2 = 0;                
        Comparator<int[]> comp = new Comparator<int[]>() {           
            public int compare(int[] a, int[] b) {
                return (a[0] == b[0] ? a[1] - b[1] : a[0]-b[0] );
            }
        };
        Arrays.sort(slots1, comp);
        Arrays.sort(slots2, comp);
        
        while(idx1 < slots1.length && idx2 < slots2.length) {
            long start = Math.max(slots1[idx1][0], slots2[idx2][0]);
            long end  = Math.min(slots1[idx1][1], slots2[idx2][1]);            
            if (end - start >= duration) {
                return Arrays.asList((int)start, (int)start + duration);
                
            }
            if (slots1[idx1][1] < slots2[idx2][1]) {
                idx1++;
            } else if(slots2[idx2][1] < slots1[idx1][1]) {
                idx2++;
            } else {
                idx1++;
                idx2++;
            }                                
        }        
        return new ArrayList();        
    }
}