package problem572;

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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
            if (rec(s,t))
                return true;        
 
        if (s!=null) {
            return (isSubtree(s.left, t) || isSubtree(s.right, t));
        }
        return false;
    }
    
    boolean rec(TreeNode s, TreeNode t) {
        if (s == null && t == null) 
            return true;
        if (s == null || t == null || s.val != t.val)
            return false;
        return rec(s.left, t.left) && rec(s.right, t.right);
    }
}