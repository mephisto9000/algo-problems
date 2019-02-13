package problem687;

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

    int max = 0;
    public int longestUnivaluePath(TreeNode root) {        
        rec(root);
        return max;
    }
    
    int rec(TreeNode root) {
        if (root == null)
            return 0;
        
        int l1 = rec(root.left);
        int l2 = rec(root.right);
    
        int v = 1;
        if (root.left != null && root.left.val == root.val)
            v += l1;
        else
            l1 = 0;
    
        if (root.right != null && root.right.val == root.val)
            v += l2;
        else
            l2 = 0;
        
        max = Math.max(max, v-1);
     
        return Math.max(l1+1, l2+1);
    }
     
}