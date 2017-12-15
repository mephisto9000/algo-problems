package problem337;

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
    
    Map<TreeNode,Integer> map;     
    int c;
    int memo[][];
    public int rob(TreeNode root) {                
        map = new HashMap();
        c = 0;
        memo = new int[2][10000];
        
        Arrays.fill(memo[0], -1);
        Arrays.fill(memo[1], -1);
        
        return Math.max(rec(root, true), rec(root,false));      
    }
    
    int rec(TreeNode root, boolean use)
    {                
        if (root == null)
            return 0;
        
        if (!map.containsKey(root))
        {            
            map.put(root, c);
            c++;
        }
        
        int u = use == true? 1 : 0;
        int v = (Integer) map.get(root);
        if (memo[u][v]>=0)
            return memo[u][v];
        
        
        if (use)        
            memo[u][v] = root.val + rec(root.left, false) + rec(root.right, false);
        else
        {
            int v1 = rec(root.left, true) + rec(root.right, true);
            int v2 = rec(root.left, true) + rec(root.right, false);
            int v3 = rec(root.left, false) + rec(root.right, true);
            int v4 = rec(root.left, false) + rec(root.right, false);
            
            int ans = v1;
            if (v2 > ans)
                ans = v2;
            if (v3 > ans)
                ans = v3;
            if (v4 > ans)
                ans = v4;
            memo[u][v] =  ans;
        }
        
        return memo[u][v];
    }         
}