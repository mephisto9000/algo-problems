package problem94;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        if (root == null)
            return new LinkedList<Integer>();
        
        List<Integer> l = inorderTraversal(root.left);
        
        l.add(root.val);
        
        l.addAll(inorderTraversal(root.right));
        
        return l;
        
    }
}