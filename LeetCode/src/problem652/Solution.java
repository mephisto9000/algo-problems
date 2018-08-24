package problem652;

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
    
    Set<String> dups;
    Map<String, TreeNode> map;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        map = new HashMap();
        dups = new HashSet();
        
        rec(root);
        List<TreeNode> l = new LinkedList();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            l.add((TreeNode)pair.getValue());
        
        }        
        return l;        
    }
    
    String rec(TreeNode root) {
        if (root == null)
            return "";
        
        StringBuffer sb = new StringBuffer();
        String valStr = Integer.toString(root.val);
        sb.append(root.val);
                        
        sb.append('.');
        sb.append(rec(root.left));
        sb.append('.');
        sb.append(rec(root.right));
        
        String s = sb.toString();
        if (dups.contains(s))
            map.put(s, root);  
        
        dups.add(s);                
        return s;
    }
}