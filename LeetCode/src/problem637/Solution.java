package problem637;

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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<TreeNode> nextList = new LinkedList();
        if (root!=null)
            nextList.add(root);
        
        List<TreeNode> curList = null;
        List<Double> ans = new LinkedList();
        while(nextList.size() > 0)
        {
            curList = nextList;
            nextList = new LinkedList();
            
            long sum = 0;
            int cnt = 0;
            Iterator<TreeNode> it = curList.iterator();
            while(it.hasNext()) {
                TreeNode tmpNode = it.next();
                sum += tmpNode.val;
                cnt ++;
                if (tmpNode.left!=null)
                    nextList.add(tmpNode.left);
                if (tmpNode.right!=null)
                    nextList.add(tmpNode.right);
            }
            
            ans.add(((double)sum)/cnt);
        }
        return ans;
        
    }
}