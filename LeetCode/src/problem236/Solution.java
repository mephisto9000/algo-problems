package problem236;

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
    
    Map<String, TreeNode> map;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
        List<TreeNode> list1 = new LinkedList();
        List<TreeNode> list2 = new LinkedList();
        
        dfs(root, p, list1);
        dfs(root, q, list2);
        
        Iterator<TreeNode> it1 = list1.iterator();
        Iterator<TreeNode> it2 = list2.iterator();
        TreeNode ans = null;
        while (it1.hasNext() && it2.hasNext())
        {
            TreeNode t1 = it1.next();
            TreeNode t2 = it2.next();
            
            if (t1 == t2)
                ans = t1;
            else
                break;
        }
           
        return ans;
         
        
    }
    
    boolean dfs(TreeNode root, TreeNode target, List<TreeNode> list)
    {
        if (root == null)
            return false;
        
        if (root == target)
        {
            list.add(0, root);
            return true;            
        }
        
        if (dfs(root.left, target, list) || dfs(root.right, target, list) )
        {
            list.add(0, root);
            return true;
        }
        
        return false;
    }
}