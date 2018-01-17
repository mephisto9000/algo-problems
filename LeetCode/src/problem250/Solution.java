package problem250;

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
    
    
    Map<TreeNode, Boolean> marked;
    
    public int countUnivalSubtrees(TreeNode root) {
        marked = new HashMap();
        
        
        int ans = 0;
        
        if (root == null)
            return 0;
        
        //if (isUni(root))
        //    ans --;
        isUni(root);
        
        
        for (Map.Entry<TreeNode, Boolean> entry : marked.entrySet())
        {
             if (entry.getValue())
                 ans ++;
        }
        
        return ans;
            
    }
    
    
    boolean isUni(TreeNode root)
    {
        if (root == null)
            return true;
        
        if (root.left == null && root.right == null)
        {         
            marked.put(root, true);
            return true;
        }
        
        if (marked.containsKey(root))
        {            
            return marked.get(root);
        }
        boolean l = isUni(root.left);
        boolean r = isUni(root.right);
        if ( l && r)
        {
            if ((root.left!= null && root.val != root.left.val) || (root.right!=null && root.val != root.right.val))
            {            
                marked.put(root, false);
                return false;
            }
            
            marked.put(root, true);
            return true;
        }
        
        System.out.println("not here");
        marked.put(root, false);
        return false;
        
        
    }
}