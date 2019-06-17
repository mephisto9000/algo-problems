package problem236;

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
    
    TreeNode ans,p,q = null;
    
    private static int Q_VAL = -1;
    private static int P_VAL = 1;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        
        rec(root);
        
        return ans;
        
    }
    
    
    int rec(TreeNode root) {
        if (root == null)
            return -100;
        
        
        
        int a1 = rec(root.left);
        int a2 = rec(root.right);
        
        if (root.val == p.val) {
            if (a1 == Q_VAL || a2 == Q_VAL)
                ans = root;
        }
        
        if (root.val == q.val) {
            if (a1 == P_VAL || a2 == P_VAL)
                ans = root;
        }
        
        
        if (a1 + a2 == 0) {
            ans = root;
        }
        
        if (root.val == p.val)
            return 1;
        if (root.val == q.val)
            return -1;
        
        return Math.max(a1,a2);
    }
}