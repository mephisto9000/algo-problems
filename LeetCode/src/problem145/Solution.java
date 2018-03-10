package problem145;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> ans = new LinkedList();
        if (root == null )
            return ans;
        Stack<TreeNode> st = new Stack();
        Set<TreeNode> used = new HashSet();
        
        st.push(root);
        while (st.size() > 0)
        {
            TreeNode head = st.peek();
            
            if (!used.contains(head))
            {
                if (head.right!=null)
                    st.push(head.right);
                
                if (head.left!=null)
                    st.push(head.left);
                
                used.add(head);
            }
            else
            {
                ans.add(head.val);
                st.pop();
            }
        }
        
        return ans;
        
    }
}