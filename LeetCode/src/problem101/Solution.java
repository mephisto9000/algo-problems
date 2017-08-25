package problem101;

import java.util.Arrays;

public class Solution {
	
	 
    
    StringBuffer stree[];
    int treeSizes[];
    int size;
    
    int deepestLevel = 0;
    public boolean isSymmetric(TreeNode root) {
        

    	treeSize(root,1);
    	
    	size = 1;
    	for (int i = 0; i < deepestLevel; i++)
    	{
    		size *= 2;
    		
    	}
    	
    	treeSizes = new int[deepestLevel];
    	
    	//
    	stree = new StringBuffer[deepestLevel];
    	
    	for (int i = 0; i < deepestLevel; i++)
    		stree[i] = new StringBuffer();
        
        if (size == 1)
        	return true;
        
        
        	
        //tree = new int[2*size];
        
        //Arrays.fill(tree, Integer.MIN_VALUE);
        
        unmarshal(root, 1, 0);
        
        
        
        
        
        int i = 0;
        int len = 1;
        
        while (i < size)
        {
            int z = 0;
            for (int j = i; j <= (i+ len / 2); j++)
            {
            	z++;
                if (tree[j] != tree[i + len - z ] )
                    return false;

                
            }
            i += len;
            
            len *=2;
        }
        
        return true;
        
    }
    
    void unmarshal(TreeNode root, int idx, int level)
    {
        if (idx > size || root == null)
            return;
                
        int i1 = idx * 2 ;
        int i2 = idx * 2 + 1;
        
        treeSizes[level] ++;

        if (stree[level] == null)
        	stree[level] = new StringBuffer();
        
        
        stree
        
        
        
        unmarshal(root.left, i1, level + 1);
        unmarshal(root.right, i2, level + 1);
        
        
    }
    
    int treeSize(TreeNode root, int level)
    {
    	if (root == null)
    		return 0;
    	
    	if (level>deepestLevel)
    		deepestLevel = level;
    	
    	
        if (root.left == null && root.right == null)
            return 1;
        
        else
            return 1 + ((root.left == null)?1:treeSize(root.left, level +1)) + (root.right == null ? 1: treeSize(root.right, level+1));
    }
}