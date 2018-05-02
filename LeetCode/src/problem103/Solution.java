package problem103;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new LinkedList();  
        if (root == null)
            return ans;
        List<TreeNode> current = new LinkedList();
        List<TreeNode> next = null;
        current.add(root);
        
          
        int mode = 0;
        while(!current.isEmpty()) {                                    
            //Collections.reverse(current);
            List<Integer> ansLevel = new LinkedList();
            next = new LinkedList();            
            while(!current.isEmpty()) {
                TreeNode tn = current.remove(0);
                ansLevel.add(tn.val);
                if (tn.left != null)
                    next.add(tn.left);
                if (tn.right != null)
                    next.add(tn.right);
            }
            if (mode == 1)
                Collections.reverse(ansLevel);
            
            mode ^= 1;
            
            ans.add(ansLevel);
            //Collections.reverse(next);
            
            current = next;                                    
        }
        
        return ans;
        
    }
}