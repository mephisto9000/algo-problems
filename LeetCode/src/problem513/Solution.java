package problem513;

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
    
    public int findBottomLeftValue(TreeNode root) {
    
        Deque<TreeNode> q = new LinkedList();
        
        q.add(root);
        int ans = -1;
        while(!q.isEmpty()) {
            ans = q.peekFirst().val;
            
            Deque<TreeNode> tmp = new LinkedList();
            for (TreeNode tn : q) {
                if (tn.left != null)
                    tmp.add(tn.left);
                if (tn.right != null)
                    tmp.add(tn.right);
            }
            
            q = tmp;
        }
        
        return ans;
        
        
    }
}