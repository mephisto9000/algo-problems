package problem373;

class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<int[]> ans = new LinkedList<>();
        
        for (int i = 0; i < nums1.length; i++)
            for (int j = 0; j < nums2.length; j++) {
                int pair[] = new int[2];
                pair[0] = nums1[i];
                pair[1] = nums2[j];
                ans.add(pair);
            }
        
        Collections.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[]a, int[]b) {
                return (a[0]+a[1]) - (b[0]+b[1]);
            }
        });
            
        return ans.subList(0, Math.min(k, ans.size()));    
    }
}