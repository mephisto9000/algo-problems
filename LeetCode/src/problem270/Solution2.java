package problem270;

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
        
    public int closestValue(TreeNode root, double target) {
        
        
        
        if (root.val == target)
            return root.val;
        
        if (root.val > target)
            return findClose(root.val, root.left!=null?closestValue(root.left, target):Long.MIN_VALUE, target);
        else
            return findClose(root.val, root.right!=null?closestValue(root.right, target):Long.MAX_VALUE, target);
        
    }
    
    int findClose(long a, long b, double target) {
        double adiff = Math.abs( a-target);
        double bdiff = Math.abs( b-target);
        
        return (int) (adiff-bdiff < 0?a: b);
    }
}