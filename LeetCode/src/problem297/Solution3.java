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
    int desIdx = 0;
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {        
        serializeRec(root);
        return sb.toString();
    }
    
    void serializeRec(TreeNode root) {
        if (root == null) {
            storeNode(root);
            return;
        }          
        
        storeNode(root);
        serializeRec(root.left);
        serializeRec(root.right);                            
    }
    
    void storeNode(TreeNode root) {        
            if (sb.length() > 0)
                sb.append(',');
            if (root == null) 
                sb.append('X');
            else
                sb.append(root.val);        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (desIdx >= data.length()) {
            return null;
        }
        
        if (data.charAt(desIdx) == ',')
            desIdx++;
        
        if (data.charAt(desIdx)=='X') {
            desIdx ++;
            return null;
        }
        
        int v = 0;
        int sign = 1;
        while(desIdx < data.length() && data.charAt(desIdx)!=',') {
            if (data.charAt(desIdx) == '-')
                sign = -1;
            else
                v = 10*v + (data.charAt(desIdx) - '0');
            desIdx++;
        }
        
        TreeNode node = new TreeNode(v*sign);
        node.left = deserialize(data);
        node.right = deserialize(data);
        return node;                
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));