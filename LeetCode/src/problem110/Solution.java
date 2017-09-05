package problem110;

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
    
    boolean isOk = true;
    
    public boolean isBalanced(TreeNode root) {
    
        dfs(root, 0);
        
        if (isOk)
            return true;
        else
            return false;
        
    }
    
    public int dfs(TreeNode node, int depth)
    {       
        if (node == null)
            return 0;
        
        int v1 = dfs(node.left, depth + 1);
        int v2 = dfs(node.right, depth + 1);
        
        if (Math.abs(v1-v2) > 1)
            isOk = false;
        
        if (v1 > v2)
            return v1 + 1;
        return v2 + 1;
        
    }
    
    
}