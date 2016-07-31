package problem1_7;

import java.util.ArrayList;

public class Problem7 {

	public static int [][] matrix = {
			{1, 2, 3, 1},
			{3, 3, 0, 3},
			{5, 3, 9, 3},
			{3, 3, 5, 6}
	};
	
	public static int m;
	public static int n;
	
	public void process()
	{
	   m = matrix.length;
	   n = matrix[0].length;
	   
	   ArrayList<Integer> target_i = new ArrayList<Integer>();
	   ArrayList<Integer> target_j = new ArrayList<Integer>();
	   
	   for (int i = 0; i < m; i++)
	   {
		   for (int j = 0; j < n; j++)
		   {
			   if (matrix[i][j] == 0)
			   {
				   target_i.add(i);
				   target_j.add(j);
			   }
		   }
	   }
	   
	   for (int i = 0; i < target_i.size(); i++)
	   {
		   nullify(target_i.get(i), target_j.get(i));
	   }
	}
	
	
	public void nullify(int out_i, int out_j)
	{
		for (int i = 0; i < m; i++)
		{
			matrix[i][out_j] = 0;
		}
		
		for (int j = 0; j < n; j++)
		{
			matrix[out_i][j] = 0;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem7 s = new Problem7();
		s.process();
		
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				System.out.print(matrix[i][j]);
				System.out.print(' ');
				
				
			}
			System.out.println();
		}
		
	}

}
