package problem508;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */



class Solution {
    
    Map<Integer, Integer> m;    
    
    public int[] findFrequentTreeSum(TreeNode root) {
        
        m = new HashMap();
        
        rec(root);
        
        int maxKey = -1;
        int maxVal = Integer.MIN_VALUE;
        List<Integer> keys = new LinkedList();
        int i = 0;
        Iterator<Map.Entry<Integer, Integer>> it = m.entrySet().iterator();
        while (it.hasNext()) {
            
            Map.Entry<Integer, Integer> pair = (Map.Entry)it.next();
            if (maxVal < pair.getValue()) {
                maxKey = pair.getKey();
                maxVal = pair.getValue();
            }               
         }
        
         it = m.entrySet().iterator();
        while (it.hasNext()) {
            
            Map.Entry<Integer, Integer> pair = (Map.Entry)it.next();
            if (pair.getValue() == maxVal) {
                keys.add(pair.getKey());
            }
         }
        
        int[] integers = new int[keys.size()];
        for (i = 0; i < integers.length; i++) {
        integers[i] = keys.get(i);
        }
            
        return integers;
  }
              
    int rec(TreeNode root) {
        
        if (root == null)
            return 0;
        
        int s = rec(root.left) + rec(root.right) + root.val;
        
        m.put(s, m.getOrDefault(s, 0)+1);
        return s;
    }
}