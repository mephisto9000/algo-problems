package problem52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    
    int q[][];
    int n ;
    
    char tmp[][];
    
    List<List<String>> ans;
    
	public static void main(String[] args) {		

	}
    
    public int totalNQueens(int n) {

        ans = new ArrayList();
        
        tmp = new char[n][n];

        q = new int[n][2];
        this.n = n;
        
        setRow(0, 0);
        
        return ans.size();
    }
    
    void setRow(int row, int qnum)
    {
    	if (row >= n)
    		return;
    	
    	for (int i = 0; i < n; i++)
    	{
    		
    		q[qnum][0] = row;
    		q[qnum][1] = i;
    		
    		if (test(qnum+1))
    		{
    			if (qnum==n-1)
    				save();

    			setRow(row+1, qnum+1);
    		}
    		else
    		{
 
    		}
    	}
    }
    
    List<String> save()
    {
        for (int i = 0; i < n; i++)
        {
            Arrays.fill(tmp[i], '.');             
        }
        
        for (int i = 0; i < n; i++)
            tmp[q[i][0]][q[i][1]] = 'Q';

        List<String> ans = new LinkedList<String>();

        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++)
        {
            sb.delete(0, sb.length()); 

            for (int j = 0; j < n; j++)
                sb.append(tmp[i][j]);

            ans.add(sb.toString());
        }
        
        this.ans.add(ans);
        
        return ans;
    }
    
    
    boolean test(int qlen)
    {
        int tmp[][] = new int[n][n];
        
        for (int i = 0; i < n; i++)
            Arrays.fill(tmp[i], 0);
        
        for (int i = 0; i < qlen-1; i++)
        {
            int y = q[i][0];
            int x = q[i][1];
            
            for (int j = 0; j < n; j++)
            {
                tmp[y][j] = 1;
                tmp[j][x] = 1;
            }
            
            for (int j = -n; j<=n; j++)
            {
                if(y + j >=0 && y + j < n && x + j >=0 && x + j < n)
                    tmp[y+j][x+j] = 1;
                
                if(y + j < n && y + j >= 0 && x - j >=0 && x - j < n )
                    tmp[y+j][x-j] = 1;
            }
        }
        
        if (tmp[q[qlen-1][0]][q[qlen-1][1]] == 0)
            return true;
        return false;
            
    }

}