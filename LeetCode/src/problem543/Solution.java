package problem543;

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
    int dim = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        rec(root);
        return dim;
        
    }
    
    int rec(TreeNode root) {
        
        if (root == null)
            return 0;
                
        int d1 = rec(root.left);
        int d2 = rec(root.right);
        int d = Math.max(d1,d2);
        
        if (d1+d2 > dim)
            dim = d1 + d2;
        return d+1;
    }
        
}