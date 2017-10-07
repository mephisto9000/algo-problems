package problem108;

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
    
    int[] nums;
    
    
    public TreeNode sortedArrayToBST(int[] nums) {       
        
        if (nums == null || nums.length == 0)
            return null;
        
        this.nums = nums;
        
        TreeNode root = makeTree(0, nums.length-1);
        
        return root;
    }
    
    public TreeNode makeTree(int lidx, int ridx)
    {  
        if (lidx == ridx)
            return new TreeNode(nums[lidx]);
        
        if (lidx > ridx)
            return null;
        
        int mid = (ridx + lidx) / 2;
        
        TreeNode t = new TreeNode(nums[mid]);
        
        t.left = makeTree(lidx, mid - 1);
        t.right = makeTree(mid+1, ridx);
        
        return t;
        
        
    }
}