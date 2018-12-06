package problem938;

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
    public int rangeSumBST(TreeNode root, int L, int R) {
        return rec(root, L, R);
    }
        
    int rec(TreeNode root, int L, int R) {
        if (root == null) 
            return 0;        
        int ans = 0;
        if (root.val >= L && root.val <= R)
            ans += root.val;
        ans += rec(root.left, L, R) + rec(root.right, L, R);
        return ans;
    }
}