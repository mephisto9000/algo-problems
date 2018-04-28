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
        
       helper(root);
        return max;
        
        
    }
    
    int helper(TreeNode root) {
         if (root == null)
            return 0;
        
        int left = 0;
        int right = 0;
        if (root.left != null && root.left.val == root.val)
            left =  helper(root.left) + 1;
        else
            helper(root.left) ;
        
        if (root.right != null && root.right.val == root.val)
            right =  helper(root.right) + 1;
        else
            helper(root.right);
            
         if (left + right > max)
             max = left + right;
            return Math.max(left,right);
    }
}