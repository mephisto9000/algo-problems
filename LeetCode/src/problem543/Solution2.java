package problem543;

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
    
    Map<TreeNode, Integer> depthMap = new HashMap<>();
    Map<TreeNode, Integer> diameterMap = new HashMap<>();
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        if (root == null)
            return 0;
        
        if (diameterMap.containsKey(root))
            return diameterMap.get(root);
        
        int deepLeft = depth(root.left);
        int deepRight = depth(root.right);
        
        int ans =  triMax(deepLeft + deepRight, 
                      diameterOfBinaryTree(root.left),
                      diameterOfBinaryTree(root.right));
        
        diameterMap.put(root, ans);
        return ans;
    }
    
    int depth(TreeNode root) {
        if (root == null)
            return 0;
        
        if (depthMap.containsKey(root))
            return depthMap.get(root);
        
        int ans =  Math.max(depth(root.left)+1, depth(root.right)+1);
        
        depthMap.put(root, ans);
        return ans;
    }
    
    int triMax(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        else
            return Math.max(b,c);
    }
}