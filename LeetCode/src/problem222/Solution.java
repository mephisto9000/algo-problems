package problem222;

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
    //int n = 0;
    
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        
        int ld = countDeepLeft(root);
        int lr = countDeepRight(root);
        if (ld == lr)
            return (1 << ld) - 1; 
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    
    int countDeepLeft(TreeNode root)
    {
        if (root == null)
            return 0;
        return countDeepLeft(root.left) + 1;
    }
    
    int countDeepRight(TreeNode root)
    {
        if (root == null)
            return 0;
        return countDeepRight(root.right) + 1;
    }
}