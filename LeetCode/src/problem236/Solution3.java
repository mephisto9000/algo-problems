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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
      Stack<TreeNode> lst = new Stack<>();
      Stack<TreeNode> rst = new Stack<>();
      dfs(lst, root, p);
      dfs(rst, root, q);
      
      while(lst.size() != rst.size()) {
        if (lst.size() > rst.size())
          lst.pop(); 
        else
          rst.pop();
      }
      
      while(lst.peek() != rst.peek()) {
        lst.pop();
        rst.pop();
      }
      
      return lst.pop();
      
      
    }
  
    void dfs(Stack<TreeNode> st, TreeNode root, TreeNode target) {
      if (root == null) {
        return;
      }
      
      st.push(root);
      
      if (root == target)
        return;
      
      dfs(st, root.left, target);
      
      if (st.peek() == target)
        return;
      dfs(st, root.right, target);
      
      if (st.peek() == target)
        return;
      st.pop();
    }
}