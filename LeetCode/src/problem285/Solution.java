package problem285;

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    
        if (p.right != null)
        {
            return dfs(p.right, p);
        }
        else
        {
            return topdown(root, p);
        }
    }
    
    TreeNode topdown(TreeNode root, TreeNode p)
    {
        if (root == null  )
            return null;
        
        TreeNode lr = topdown(root.left, p);
        TreeNode rr = topdown(root.right, p);
        
        TreeNode min = root;
        if (root.val < p.val)
            min = new TreeNode(Integer.MAX_VALUE);
        
        
        
        if (lr != null && lr.val < min.val && lr.val > p.val)
            min = lr;
        
        if (rr != null && rr.val < min.val && rr.val > p.val)
            min = rr;
        
       // return min;
        
        if (min.val > p.val)
        {
        	if (min.val == Integer.MAX_VALUE)
        		return null;
        	else
        		return min;
        }
        else
            return null;
    }
    
    TreeNode dfs(TreeNode root, TreeNode p)
    {
        
        if (root == null)
            return null;
        
        //if (root.val > p.val)
        //{
            if (root.left != null && root.left.val > p.val)
                return dfs(root.left, p);
                
        //}
       return root;
    }
    
    
}