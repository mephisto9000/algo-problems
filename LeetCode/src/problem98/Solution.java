package problem98;

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
    
    List<Integer> list;
    
    public boolean isValidBST(TreeNode root) {
        list = new LinkedList();
        rec(root);
        
        Integer prev  = null; 
        Iterator<Integer> it = list.iterator();
        
        while(it.hasNext())
        {
            int v = it.next();
            if (prev != null && v <=  prev)
                return false;
            prev = v;
        }
        return true;
    }
    
    void rec(TreeNode node)
    {
        if (node == null)
            return;
        
        rec(node.left);
        list.add(node.val);
        rec(node.right);
    }
}