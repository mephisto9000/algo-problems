package problem655;

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
    int h;
    List<List<String>> ans;
    public List<List<String>> printTree(TreeNode root) {
        h = height(root);
        ans = new ArrayList();
        for (int i = 0; i < h; i++)
            ans.add(new LinkedList());
        
        fillAns(root, 0);
        return ans;        
    }
    
    void fillAns(TreeNode root, int level) {
        if (level >= h)
            return;

        fillAns(root!=null?root.left:null, level + 1);
        for(int i = 0; i < h; i++) {
            List<String> l = ans.get(i);
            if (level == i && root!= null)
                l.add(Integer.toString(root.val));
            else
                l.add("");
        }
            
            
        fillAns(root!=null?root.right:null, level + 1);
    }
    
    int height(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}