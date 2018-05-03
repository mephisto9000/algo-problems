package problem116;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        rec(root, null);
    }
    
    public void rec(TreeLinkNode root, TreeLinkNode rightRoot)
    {
        if (root == null || root.left == null)
            return;
        
        root.left.next = root.right;
        
        if (rightRoot!=null) {
            root.right.next = rightRoot.left;
            rec(root.right, rightRoot.left);
        } else
            rec(root.right, null);
        
        rec(root.left, root.right);
        
            
    }
}