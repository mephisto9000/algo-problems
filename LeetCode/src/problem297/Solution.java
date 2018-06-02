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
    int maxIdx = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if (root == null)
            return "X";        
        
        StringBuffer sb = new StringBuffer();
        sb.append(root.val);
        sb.append(',');
        sb.append(serialize(root.left));
        sb.append(',');
        sb.append(serialize(root.right));        
        
        //System.out.println(sb.toString());
        return sb.toString();
        
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        return rec(data);
        
    }
    
    TreeNode rec(String data ) {
        if (maxIdx >= data.length())
            return null;
        
        int i = maxIdx;
        int v = 0;
        int minus = 1;
        while(i < data.length() && data.charAt(i)!= ',') {
            char c = data.charAt(i);
            if (c == 'X') {
                maxIdx = i+2;
                return null;
            }
            if (c == '-')            
                minus = -1;              
            else                
                v = 10*v + Character.getNumericValue(c);            
            i++;
        }
        
        TreeNode root = new TreeNode(v*minus);
        
        maxIdx = i+1;
        root.left = rec(data);
        root.right = rec(data);
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));