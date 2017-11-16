package problem102;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new LinkedList();
        
        Queue<TreeNode> q = new LinkedList();
        
        q.add(root);
        
        if (root != null)
        {
            List l = new LinkedList();
            l.add(root.val);
            
            ans.add(l);
        }
        
        while(true)
        {
            
            
            Queue<TreeNode> next = new LinkedList();
            
            List l = new LinkedList();
            while(!q.isEmpty())
            {
                
                
               TreeNode tmp = q.poll();
                //next.add(tmp);
                if(tmp!=null)
                {
                if (tmp.left != null)
                {
                    next.add(tmp.left);
                    l.add(tmp.left.val);
                }
                if (tmp.right != null)
                {
                    next.add(tmp.right);
                    l.add(tmp.right.val);
                }
                }
            }
            
            if (!l.isEmpty())
                ans.add(l);
            
            if (next.isEmpty())
                break;
            else
                q = next;
            
        }
        
        return ans;
            
            
        
        
    }
}