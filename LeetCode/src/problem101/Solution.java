package problem101;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	
	 
    
public boolean isSymmetric(TreeNode root) {
        
 
        
        return bfs(root);
        
    }
    
    
    TreeNode nope = new TreeNode(Integer.MIN_VALUE);
    
    
    boolean bfs(TreeNode root)
    {
    
        if (root == null )
            return true;
        
        Set<TreeNode> visited = new HashSet<TreeNode>();
        
        List<TreeNode> level = new ArrayList<TreeNode>();    
      
        level.add(root);
        visited.add(root);
        
        while(!level.isEmpty())
        {
            int lvlLen = level.size();
            
            int i = 0;
            int j = lvlLen - 1;
            
            //check
            boolean end = true;
            while (i <= j)
            {
                TreeNode left = level.get(i);
                TreeNode right = level.get(j);
                
                if (left != nope)
                    end = false;
                
                if (right != nope)
                    end = false;
                
                
                if (left != null && right != null && left.val != right.val)
                    return false;
                
                if ((left != null && right == null) || (left == null && right != null))
                    return false;
                
                i++;
                j--;
            }
            
            if (end)
                break;
            
            // collecting Children
            List<TreeNode> tmpLevel = new ArrayList<TreeNode>();
            
            for (TreeNode tm : level)
            {
                if (tm!=null)
                {
                    if (tm.left != null)
                        tmpLevel.add(tm.left);
                    else
                        tmpLevel.add(nope);
                        
                    if (tm.right != null)
                        tmpLevel.add(tm.right);
                    else
                        tmpLevel.add(nope);
                    
                }
                else
                {
                    tmpLevel.add(nope);
                    tmpLevel.add(nope);
                }
            }
            
            level = tmpLevel;
        
        }
        
        return true;
    }
}