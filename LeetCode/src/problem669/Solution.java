package problem669;

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
   
    public TreeNode trimBST(TreeNode root, int L, int R) {
       
        if (root == null)
            return null; 
        
        
        if (root.val <L || root.val > R)
        {
            TreeNode x = trimBST(root.left, L, R);
            if (x == null) 
                return trimBST(root.right, L, R);
            
            return x;
        }
        else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
         
    }
     
         
    
}