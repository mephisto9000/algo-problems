package problem173;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
  
    Queue<Integer> q;

    public BSTIterator(TreeNode root) {
        q = new ArrayDeque<>();
        rec(root);
    }
  
    void rec(TreeNode root) {
      if (root == null) {
        return;
      }
      
      rec(root.left);
      q.add(root.val);
      rec(root.right);
    }
  
    
    /** @return the next smallest number */
    public int next() {
        return q.poll();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!q.isEmpty());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */