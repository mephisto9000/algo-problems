package problem98;

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
    public boolean isValidBST(TreeNode root) {
        return rec(root, Long.MIN_VALUE, Long. MAX_VALUE);
    }
    
    boolean rec(TreeNode root, long lbound, long rbound) {
        if (root == null) {
            return true;
        }  
        
        if (root.val <= lbound || root.val >= rbound)
            return false;
        
        return rec(root.left, lbound, root.val) && rec(root.right, root.val, rbound);
        
        
    }
}