package problem865;

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
    Map<TreeNode, TreeNode> fatherMap;
    Map<Integer, List<TreeNode>> depthMap;
    int maxDepth = 0;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        
        fatherMap = new HashMap<>();
        depthMap = new HashMap<>();
        dfs(null, root, 1);
        
        
        List<TreeNode> candidates = depthMap.get(maxDepth);
        Set<TreeNode> uniquesSet = new HashSet(candidates);
        while(uniquesSet.size() > 1) {
            HashSet<TreeNode> tmp = new HashSet<>();
                        
            for (TreeNode uni : uniquesSet) {
                tmp.add(fatherMap.get(uni));
            }
            
            uniquesSet = tmp;
        }
        
        return uniquesSet.iterator().next();
        
    }
    
    
    void dfs(TreeNode parent, TreeNode root, int depth) {
        if (root == null)
            return;
        
        if (depth > maxDepth)
            maxDepth = depth;
        
        List<TreeNode> depthList = depthMap.getOrDefault(depth, new LinkedList<>());
        depthList.add(root);
        depthMap.put(depth, depthList);
        
        fatherMap.put(root, parent);
        
        dfs(root, root.left, depth+1);
        dfs(root, root.right, depth+1);        
    }
}