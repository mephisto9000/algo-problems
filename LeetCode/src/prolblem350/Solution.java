package prolblem350;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> m = new HashMap();
        
        for (int i = 0; i < nums2.length; i++)
            m.put(nums2[i], m.getOrDefault(nums2[i], 0)+1);
        
        List<Integer> l = new LinkedList();
        for (int i = 0; i < nums1.length; i++) {
            int v = m.getOrDefault(nums1[i], 0);
            if (v > 0) {
                l.add(nums1[i]);
                m.put(nums1[i], v-1);
            }
        }
        
        int[] ans = new int[l.size()];
        int j = 0;
        for (Integer it : l) {
            ans[j++] = it;
        }
        return ans;
        
    }
}