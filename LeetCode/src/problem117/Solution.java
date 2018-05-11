package problem117;

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
        
        if (root == null)
            return;
        rec(root);
        connect(root.left);
        connect(root.right);
        
    }
    
    void rec(TreeLinkNode root ) {
        
         
        TreeLinkNode cnode = null;
        while (root != null) {
        
        if (cnode != null) {
        if (root.left != null) {
            cnode.next = root.left;
            cnode = cnode.next;
        }
        } else
            cnode = root.left;
        if (cnode != null) {
        if (root.right!= null) {
            cnode.next = root.right;
            cnode = cnode.next;
        }
        } else
            cnode = root.right;
        
        root = root.next;
        }
        
    }
}