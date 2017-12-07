package problem235;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        List<TreeNode> ppath = new LinkedList();
        List<TreeNode> qpath = new LinkedList();
        
        getPath(root, p, ppath);
        getPath(root, q, qpath);
        
         Collections.reverse(ppath);
         Collections.reverse(qpath);
        
        Iterator pit = ppath.iterator();
        Iterator qit = qpath.iterator();
        
        TreeNode ans = root;
        while(pit.hasNext() && qit.hasNext())
        {
            //if (pit.next() == qit.next())
            TreeNode a = (TreeNode) pit.next();
            TreeNode b = (TreeNode) qit.next();
            
            if (a == b)                
                ans = a;
            else
                break;
        }
        
        return ans;
        
    }
    
    boolean getPath(TreeNode root, TreeNode target, List<TreeNode> path)
    {
        if (root == null)
            return false;
        
        if (root == target)
        {
            path.add(root);
            return true;
        }
        
        if (getPath(root.left, target, path))
        {
            path.add(root);
            return true;
        }
        if (getPath(root.right, target, path))
        {
            path.add(root);
            return true;
        }
        
        return false;
    }
}