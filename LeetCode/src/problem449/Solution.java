package problem449;

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
    int lastIdx = -1;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "X,";
        
        StringBuffer sb = new StringBuffer();
        
        sb.append(root.val+",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        
        String s = sb.toString(); 
        return s;
    }
    
   

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        return rec(data  );
    }
    
    private TreeNode rec(String data ) {
        lastIdx ++;
        
         
        
        int v = 0;
        boolean flag = false;
        while(lastIdx < data.length() && data.charAt(lastIdx) != ',') {
            if (Character.isDigit(data.charAt(lastIdx))) {
                v = 10*v + Character.getNumericValue(data.charAt(lastIdx));                
                flag = true;
            }
            lastIdx ++;
        }
        
        if (flag == false)
            return null;
        
       
        
         
        TreeNode tn = new TreeNode(v);
        tn.left = rec(data );
        tn.right = rec(data );
        
        
        return tn;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));