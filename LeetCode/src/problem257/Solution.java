package problem257;

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
    
    LinkedList path;
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        
        path = new LinkedList();
        ans = new LinkedList();
        rec(root);
        
        return ans;
        
    }
    
    void rec(TreeNode root)
    {
        if (root!= null)
        {
            path.add(root);
        }
        else return;
        
        if(root.left == null && root.right == null)
        {
            ans.add(pathToStr());
        }
        
        rec(root.left);
        rec(root.right);
        
        path.removeLast();
    }
    
    String pathToStr()
    {
        StringBuffer sb = new StringBuffer();
        Iterator it = path.iterator();
        
        while(it.hasNext())
        {
            TreeNode tn = (TreeNode) it.next();
            
            if (sb.length() != 0)
                sb.append("->");
            sb.append(tn.val);
        }
        
        return sb.toString();
    }
}