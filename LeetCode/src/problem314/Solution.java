package problem314;

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
    
    List ans;
    int leftBound;
    int rightBound;
    Map<Integer, List<Node>> map;
    
    class Node implements Comparable
    {
        int val;
        int pos;
        
        public Node(int val, int pos)
        {
            this.val = val;
            this.pos = pos;
        }
        
        @Override
        public int compareTo(Object o)
        {
            Node n = (Node) o;
            return pos - n.pos;
        }
    }
    
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List ans = new LinkedList(); 
        map = new HashMap();
        leftBound = 0;
        rightBound = 0;
        
        dfs(root, 0, 0);    
        
        for (int i = leftBound; i <= rightBound; i++)
        {
            //ans.add(map.get(i));
            List<Node> nodes = map.get(i);
            if (nodes == null)
                break;
            
            Collections.sort(nodes);
            
            List<Integer> l = new LinkedList();
            for (int j = 0; j < nodes.size(); j++)
            {
                l.add(nodes.get(j).val);
            }
            
            ans.add(l);
        }
        
        return ans;
        
    }
    
    void dfs(TreeNode root, int pos, int level)
    {
        if (root == null)
            return;
        
        if (pos < leftBound)
            leftBound = pos;
        
        if (pos > rightBound)
            rightBound = pos;
        
        if (map.containsKey(pos))
        {
            List<Node> vert = map.get(pos);
            vert.add(new Node(root.val, level));
        }
        else
        {
            List<Node> vert = new LinkedList();
            vert.add(new Node(root.val, level));
            map.put(pos, vert);
        }
        
        dfs(root.left, pos-1, level+1);
        dfs(root.right, pos+1, level+1);
    }
    
}