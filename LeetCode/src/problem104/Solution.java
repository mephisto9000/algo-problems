package problem104;

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
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        int maxl = maxDepth(root.left);
        int maxr = maxDepth(root.right);
        
        if (maxl > maxr)
            return maxl + 1;
        else
            return maxr + 1;
        
        
    }
    
    
}