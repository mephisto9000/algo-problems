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
    TreeNode last = null;
    public void flatten(TreeNode root) {
      
      if (root == null) {
        return;
      }
                 
      TreeNode left = root.left;
      root.left = null;
      TreeNode right = root.right;
      root.right = null;
      
      if (last == null) {
        last = root;
      } else {
        last.right = root;
        last = root;
      }
        
      flatten(left);
      flatten(right);
    }
}