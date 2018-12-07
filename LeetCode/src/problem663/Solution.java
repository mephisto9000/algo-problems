package problem663;

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
    boolean ans = false;
    
    Map<TreeNode, Integer> sumMap;
    int totSum = 0;
    public boolean checkEqualTree(TreeNode root) {
        sumMap = new HashMap();
        sumRec(root);
        return checkRec(root);
    }
    
    int sumRec(TreeNode root) {
        if (root == null)
            return 0;
        
        int l1 = sumRec(root.left);
        int l2 = sumRec(root.right);
        int v = l1 + l2 + root.val;
        sumMap.put(root, v);
        totSum += root.val;
        return v;
    }
    
    boolean checkRec(TreeNode root) {
        if (root == null)
            return false;
        
        if (root.left != null && totSum - sumMap.get(root.left) == sumMap.get(root.left))
            return true;
        if (root.right != null && totSum - sumMap.get(root.right) == sumMap.get(root.right))
            return true;
        
        return checkRec(root.left) || checkRec(root.right);
    }
}