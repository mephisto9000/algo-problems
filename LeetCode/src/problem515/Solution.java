package problem515;

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
    public List<Integer> largestValues(TreeNode root) {
        
        Deque<TreeNode> current = new LinkedList();
        Deque<TreeNode> next = new LinkedList();
        List<Integer> ans = new LinkedList();
        if (root == null)
            return ans;
        current.add(root);
        while(!current.isEmpty()){
            int max = Integer.MIN_VALUE;
            while(!current.isEmpty()) {
                TreeNode x = current.poll();
                max = Math.max(max, x.val);
                if (x.left!= null)
                    next.add(x.left);
                if(x.right!=null)
                    next.add(x.right);
            }
            ans.add(max);
            current = next;
            next = new LinkedList();
        }
        
        return ans;
        
        
    }
}