package problem107;

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
    
    int level = 0;
    List<List<Integer>> list;
    
        
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        if (root == null)
            return  new ArrayList<List<Integer>>();
        
        
        
        if (list == null)
            list = new ArrayList<List<Integer>>();
        
        if (list.size() < level + 1)
            list.add(new LinkedList());    
     
        List<Integer> l = list.get(level);
        
        l.add(root.val);
            
        
        
            
            
        level ++;
        
        levelOrderBottom(root.left);
        levelOrderBottom(root.right);
        
        
        level --;
        
        
        if (level == 0)
        {
            int depth = list.size();
            List<List<Integer>> inv = new LinkedList<List<Integer>>();
            
            int z = depth;
            for (List<Integer> tl = list.get(depth - 1); depth >0; depth -- )
            {
                z--;
                List<Integer> tl1 = list.get(z);
                inv.add(tl1);
            }
                
            //return list;
            return inv;
        }
        else
            return null; 
        
    }
}