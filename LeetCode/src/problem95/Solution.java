package problem95;

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
    
    Map<int[], List<TreeNode>> cache;
    public List<TreeNode> generateTrees(int n) {
        cache = new HashMap();
        if (n < 1)
            return new LinkedList();
        return rec(1, n);
    }
    
        
    TreeNode enode = new TreeNode(-1);
    
    List<TreeNode> rec(int lb, int  rb) {
        int key[] = new int[]{lb,rb};
                
        if (lb > rb || cache.containsKey(key)) {            
            List<TreeNode> empty = new LinkedList(); 
            empty.add(enode);
            return empty;
        }
        
        List<TreeNode> list = new ArrayList();
        
        for (int i = lb; i <= rb; i++) {            
            List<TreeNode> l = rec(lb, i-1);
            List<TreeNode> r = rec(i+1, rb);
            
            for (TreeNode tl : l)
                for (TreeNode tr : r) {
                    TreeNode root = new TreeNode(i);
                    if (tl.val != -1)
                        root.left = tl;
                    if (tr.val != -1)
                        root.right = tr;
                    
                    list.add(root);
                }
            
            
        }
        
        cache.put(key, list);
        return list;
        
    }
}