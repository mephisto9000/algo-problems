package problem114;

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
    
    TreeNode result;
    TreeNode tail;
    
    public void flatten(TreeNode root) {
        
        rec(root);
        //root =  result;
        if (root!= null)
        root.left = null;
        if (result != null && result.right != null)
        root.right = result.right;
        
    }
    
    void rec(TreeNode root)
    {
        if (root == null)
            return ;
        
        if (result == null)
        {
            result = new TreeNode(root.val);
            tail = result;
        }
        else
        {
            TreeNode t = new TreeNode(root.val);
            tail.left = null;
            tail.right = t;
            tail = t;
        }
        
        rec(root.left);
        rec(root.right);
    }
}