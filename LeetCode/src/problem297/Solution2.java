package problem297;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        
        StringBuffer sb = new StringBuffer();
        
        srRec(sb, root);
        
       
        return sb.toString();
        
    }
    
    void srRec(StringBuffer sb, TreeNode root) {
        append(sb, root);
        if (root == null) {
            return;
        }
        
        srRec(sb, root.left);
        srRec(sb, root.right);
            
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String vals[] = data.split(",");
        
        List<String> list = Arrays.asList(vals);
        Deque<String> d = new LinkedList(list);  
        
        return desRec(d);
    }
    
    TreeNode desRec(Deque<String> vals) {
 
        
        if (vals.size() == 0)
            return null;
        
        String v = vals.pollFirst();
        
        System.out.println(v);
        if (v.equals("F"))
            return null;
        
        
        TreeNode ans = new TreeNode(Integer.valueOf(v));
        
        ans.left = desRec(vals);
        ans.right = desRec(vals);
        return ans;
        
    }
    
    void append(StringBuffer sb, TreeNode node) {
 
        if (sb.length()>0)
            sb.append(",");
        if (node == null)
            sb.append("F");
        else
            sb.append(node.val);
 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));