package problem349;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      
      Set<Integer> fset = new HashSet<>();
      
      for(int i = 0; i < nums1.length; i++)
        fset.add(nums1[i]);
      
      Set<Integer> ansSet = new HashSet<Integer>();
      for (int i = 0; i < nums2.length; i++) {
        if (fset.contains(nums2[i]))
          ansSet.add(nums2[i]);
      }
      
      int[] ans = new int[ansSet.size()];
      int idx = 0;
      for (Integer x : ansSet)
        ans[idx++] = x;
      
      
      return ans;
      
    }
}