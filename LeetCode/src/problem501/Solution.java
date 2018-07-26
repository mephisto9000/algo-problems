package problem501;

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
    
    Map<Integer, Integer> map;
    
    public int[] findMode(TreeNode root) {
                
        map = new HashMap();
        
        rec(root);
        
        
        Set<Integer> ks = map.keySet();
        
        int max = -1;
        List<Integer> ans = new ArrayList();
        for (int k : ks) {
            
            int tmp = map.get(k);
             
            if (tmp > max) {
                max = tmp;
                ans.clear();
                ans.add(k);
            } else
            if (tmp == max) {
                ans.add(k);
            }
        }
        
        int[] ans2 = new int[ans.size()];
        for (int i = 0; i < ans2.length; i++) {
            ans2[i] = ans.get(i);
        }
        return ans2; 
        
        
    }
    
    void rec(TreeNode root) {
        if (root == null)
            return ;
        
        
        if (map.containsKey(root.val)) {
            int v = map.get(root.val);
            
             
            map.put(root.val, v+1);
        } else
            map.put(root.val, 1);
        
        rec(root.left);
        rec(root.right);
    }
}