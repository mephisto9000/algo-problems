package problem230;

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
    
    int notFound = 1234567;
    int counter = 0;
    int ans = 0;
    int k;
    
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        rec(root);
        return ans;             
    }
    
    int rec(TreeNode root) {
         if (root == null)
            return notFound;
       
        int l = rec(root.left);
        
        if (l!=notFound) 
            return l;
        counter++;
        if (counter == k) {
            ans = root.val;
            return 0;
        }
        
        int r = rec(root.right);
        if (r != notFound)  
            return r;
        return notFound;
        
    }
}