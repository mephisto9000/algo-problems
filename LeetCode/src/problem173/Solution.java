package problem173;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Deque<Integer> nodes;
    
    public BSTIterator(TreeNode root) {
        nodes = new LinkedList();
        dfs(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (nodes.size() > 0);
    }

    /** @return the next smallest number */
    public int next() {
        return nodes.pollFirst();
    }
    
    void dfs(TreeNode n) {        
        if (n == null)
            return;
        dfs(n.left);
        nodes.addLast(n.val);
        dfs(n.right);
    }

        
}


/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */