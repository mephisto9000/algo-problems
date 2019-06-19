package problem958;

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
    
    List<Integer> depth;
        
    public boolean isCompleteTree(TreeNode root) {
        depth = new LinkedList<>();
        dfs(root, 0);
        
        int last = -1;
        boolean shift = false;
        for (Integer v : depth) {
            if (last == -1)
                last = v;
            else {                
                if (last - v  > 1 || last - v < 0)
                    return false;
                if (last - v  == 1) {
                    if (!shift)
                        shift = true;
                    else
                        return false;
                }
                last = v;
                    
            }
        }
        
        return true;
    }
    
    void dfs(TreeNode root, int curDepth) {
        if (root == null) {
            //update depth
            depth.add(curDepth);
            return;
        }
        
        dfs(root.left, curDepth+1);
        dfs(root.right, curDepth+1);
    }
}