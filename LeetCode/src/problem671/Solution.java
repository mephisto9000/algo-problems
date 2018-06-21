package problem671;

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
    
    PriorityQueue<Integer> pq = new PriorityQueue(2);
    
    public int findSecondMinimumValue(TreeNode root) {
        rec(root);
        if (pq.size() < 2)
            return -1;
        pq.poll();
        return pq.poll();
    }
    
    void rec(TreeNode root) {
        if (root == null)
            return;
        if (pq.size() == 0 || pq.peek() != root.val)
            pq.add(root.val);
        
        rec(root.left);
        rec(root.right);
    }
}