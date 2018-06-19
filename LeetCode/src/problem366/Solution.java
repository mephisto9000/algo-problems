package problem366;

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
    
    Map<Integer, List<Integer>> map = new HashMap();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        depth(root);
        List<List<Integer>> ans = new LinkedList();
        //for (int i = maxDepth; i >= 0; i--)
        int i = 1;
        while(map.containsKey(i)) {
            ans.add(map.get(i));
            i++;
        }
        return ans;
        
    }
    
    int depth(TreeNode root ) {
        if (root == null)
            return 0;
        
        //maxDepth = Math.max(deep, maxDepth);
        
        
        
        int d = Math.max(depth(root.left), depth(root.right)) + 1;
        
        List<Integer> l = null;
        if (map.containsKey(d)) {
            l = map.get(d);
        } else {
            l = new LinkedList();
            map.put(d, l);
        }
        l.add(root.val);
        
        return d;
        
        
        
    }
}