package problem226;

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
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null)
            return null;
        
        if (root.left == null && root.right == null)
            return root;
        
        TreeNode r = invertTree(root.left);
        TreeNode l = invertTree(root.right);
        root.right = r;
        root.left = l;
        
        return root;
        
    }
}