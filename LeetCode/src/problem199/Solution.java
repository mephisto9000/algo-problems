package problem199;

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
    
    List<Integer> ans;
    //int level;
    
    public List<Integer> rightSideView(TreeNode root) {
        
        ans = new ArrayList<Integer>();
        
        rec(root, 0);
        return ans;
        
    }
    
    void rec(TreeNode root, int level)
    {
        if (root == null)
            return;
            
        level ++;
        
        if (ans.size() < level)
            ans.add(root.val);    
        else
            ans.set(level-1, root.val);
        rec(root.left, level);
        rec(root.right, level);
    }
}