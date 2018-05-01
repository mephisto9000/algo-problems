package problem144;

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
    Deque<TreeNode> stack;
    public List<Integer> preorderTraversal(TreeNode root) {
        ans = new LinkedList();
        stack = new LinkedList();
        if (root != null)
            stack.addLast(root);
        while(stack.size() > 0) {
            TreeNode t = stack.pollLast();
            ans.add(t.val);
            if (t.right != null)
            stack.add(t.right);
            if (t.left != null)
            stack.add(t.left);
            
        }
        
        return ans;
    }
    
}