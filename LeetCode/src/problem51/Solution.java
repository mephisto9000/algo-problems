package problem51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    
    int q[][];
    int n ;
    
    char tmp[][];
    int testtmp[][];
    
    List<List<String>> ans;
    
	public static void main(String[] args) {		

	}
    
    public List<List<String>> solveNQueens(int n) {

        ans = new ArrayList();
        
        tmp = new char[n][n];

        q = new int[n][2];
        this.n = n;
        
        for (int i = 0; i < n; i++)
        {
            Arrays.fill(tmp[i], '.');             
        }
        
        setRow(0, 0);
        
        return ans;
    }
    
    void setRow(int row, int qnum)
    {
    	if (row >= n)
    		return;
    	                     
        pretest(qnum+1);
        
        List<Integer> avail = new LinkedList();
        for (int i = 0; i < n; i++)
    	{
            if (testtmp[row][i]==0)
                avail.add(i);
        }

        Iterator it = avail.iterator();
        
        while(it.hasNext())
    	{
            int i = (Integer) it.next();
                		
    		q[qnum][0] = row;
    		q[qnum][1] = i;
                       
            tmp[row][i] = 'Q';
                
    		if (qnum==n-1)
    			save();

    		setRow(row+1, qnum+1);                
            tmp[row][i] = '.';
    		    		 
    	}
    }
    
    List<String> save()
    {                
 
        List<String> ans = new LinkedList<String>();

        for (int i = 0; i < n; i++)
        {        	                          
            ans.add(new String(tmp[i]));
        }
             
        this.ans.add(ans);
                 
        return ans;
    }
    
    
    void pretest(int qlen)
    {
        testtmp  = new int[n][n];
        
        for (int i = 0; i < n; i++)
            Arrays.fill(testtmp[i], 0);
        
        for (int i = 0; i < qlen-1; i++)
        {
            int y = q[i][0];
            int x = q[i][1];
            
            for (int j = 0; j < n; j++)
            {
                testtmp[y][j] = 1;
                testtmp[j][x] = 1;
            }
            
            for (int j = -n; j<=n; j++)
            {
                if(y + j >=0 && y + j < n && x + j >=0 && x + j < n)
                    testtmp[y+j][x+j] = 1;
                
                if(y + j < n && y + j >= 0 && x - j >=0 && x - j < n )
                    testtmp[y+j][x-j] = 1;
            }
        }
        
       
            
    }
    
    boolean test(int qlen)
    {
         if (testtmp[q[qlen-1][0]][q[qlen-1][1]] == 0)
            return true;
        return false;
    }

}

