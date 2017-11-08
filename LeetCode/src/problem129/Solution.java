package problem129;

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
    int sum = 0;
    int len = 0;
    
    public int sumNumbers(TreeNode root) {
        rec(root, new StringBuffer());
        return sum;
    }
    
    void rec(TreeNode root, StringBuffer sb)
    {
        if (root == null)
        {
           return;        
        }        
        sb.append(root.val);
        len++;
        if (root.left == null && root.right ==null)
        {
            if (len > 0)
            {
                sum += Integer.parseInt(sb.toString());                 
                
            }
             sb.deleteCharAt(len - 1);
            len --;
            return;   
        }
        
        rec(root.left,sb);
        rec(root.right,sb);
        sb.deleteCharAt(len - 1);
        len --;
        
    }
}