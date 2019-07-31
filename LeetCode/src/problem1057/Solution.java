package problem1057;

class Solution {            
    List<int[]> pairs;
    
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        
        pairs = new ArrayList<>();
        
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int[] pair = {i,j, Math.abs(workers[i][0] - bikes[j][0]) +
                              Math.abs(workers[i][1] - bikes[j][1])};
                pairs.add(pair);
            }
            
        }
        
        Collections.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[]b) {
                if (a[2] == b[2]) {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    } else {
                        return a[0]-b[0];
                    }
                } else {
                    return a[2]-b[2];
                }
            }
        });
        
        int[] ans = new int[workers.length];
        Set<Integer> wUsed = new HashSet<>();
        Set<Integer> bUsed = new HashSet<>();
        
        int z = 0;
        for (int i = 0; i < pairs.size(); i++) {
            int[] p = pairs.get(i);
            if (wUsed.contains(p[0]) || bUsed.contains(p[1]))
                continue;
            ans[p[0]] = p[1];
            wUsed.add(p[0]);
            bUsed.add(p[1]);
        }
        return ans;
    }
}