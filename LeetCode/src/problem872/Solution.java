package problem872;

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
    
    
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    
        List<Integer> l1 = new LinkedList();
        List<Integer> l2 = new LinkedList();
        
        rec(root1, l1);
        rec(root2, l2);
        
        Iterator<Integer> it1 = l1.iterator();
        Iterator<Integer> it2 = l2.iterator();
        
                
        while(it1.hasNext()) {
            int v1 = it1.next();
            if (!it2.hasNext())
                return false;
            int v2 = it2.next();
                         
            if (v1 != v2)
                return false;
        }
        
        return !it2.hasNext();
    }
    
    void rec(TreeNode root, List<Integer> l) {
        
        if (root == null)
            return;
        
         if (root.left == null && root.right == null)
             l.add(root.val);
        rec(root.left, l);
        rec(root.right,l);
                   
    }
}