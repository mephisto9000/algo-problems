package problem270;

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
    
    int lastVal = 0;
    public int closestValue(TreeNode root, double target) {
        
        TreeNode dad = new TreeNode(root.val);
        
        return rec(root, target, dad);              
        
    }
    
    int rec(TreeNode root, double target, TreeNode dad) {
         if (root == null) 
            return dad.val ; 
                
        int a =   root.val;                
        int  b =    target < root.val?  rec(root.left, target, root)  :  rec(root.right, target, root);         
        return  Math.abs((double) a - target) < Math.abs((double) b - target) ? a : b;         
    }
    
     
        
}