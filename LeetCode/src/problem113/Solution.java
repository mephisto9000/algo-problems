package problem113;

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
    
    List<List<Integer>> ans;
    
    Stack stack;
    int sum;       
    
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        ans = new LinkedList();
        stack = new Stack();
        this.sum = sum;
        
        rec(root, 0);
        
        return ans;
        
    }
    
    void rec(TreeNode node, int locSum)
    {
        if (node == null)
            return;
        
        stack.push(node.val);
        
        locSum += node.val;
        
        if (node.left == null && node.right == null)
        {
            if (locSum == sum)
            {
                List l = new LinkedList(stack);
                ans.add(l);
            }
        }
        
        rec(node.left, locSum);
        rec(node.right, locSum);
        
        stack.pop();
    }
}