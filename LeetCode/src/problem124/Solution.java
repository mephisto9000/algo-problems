package problem124;

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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        recPathSum(root);
        return max;
        
    }
    
    int recPathSum(TreeNode root) {
        if (root == null)
            return 0;
        
        int leftMax = recPathSum(root.left);
        int rightMax = recPathSum(root.right);
        
        //consider pants
        int ans = root.val + leftMax + rightMax;
        max = Math.max(max, ans);
        
        //consider vertical path
        ans = root.val + triMax(0, leftMax, rightMax);
        max = Math.max(max, ans);
            
        return ans;               
    }
    
    int triMax(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        else
            return Math.max(b, c);
    }
}