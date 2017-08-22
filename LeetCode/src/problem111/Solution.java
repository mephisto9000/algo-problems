package problem111;

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
    int depth = Integer.MAX_VALUE;
    
    int curDepth = 0;
    
    public int minDepth(TreeNode root) {
        
        if (root == null)
            return 0;
        
        curDepth ++;
        
        if (root.left == null && root.right == null && curDepth < depth)
            depth = curDepth;
            
            
        minDepth(root.left);
        minDepth(root.right);
        
        curDepth --;
        
        if (curDepth == 0)
        {
            if (depth == Integer.MAX_VALUE)
                depth = 0;
            
            return depth;
        }
        
        return curDepth;
        
        
        
    }
}