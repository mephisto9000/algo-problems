package problem606;

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
    
    
    public String tree2str(TreeNode t) {
        StringBuffer sb = new StringBuffer();
        return rec(t,sb).toString();
    }
    
    StringBuffer rec(TreeNode t, StringBuffer sb) {
        if (t == null)
            return sb;
                        
        sb.append(t.val);
        
        if (t.left==null && t.right==null)
            return sb;
        
        sb.append('(');
        rec(t.left,sb);
        sb.append(')');
        
        if (t.right!=null)
            sb.append('(');
        rec(t.right, sb);
        if (t.right!=null)
            sb.append(')');
        return sb;
    }
}