import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solution {
	
	public class Elefant{
		public int x;
		public int y;
						
	}
	
	public class Pair{
		public int x1;
		public int x2;
		
		public int y1;
		public int y2;
		
		
	}
	
	
	
	
	Elefant[][] matrix;
	Set<Pair> ansList;
	
	
	public void calc() throws Throwable
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		
		int n = Integer.parseInt(br.readLine());
		
		matrix = new Elefant[1000][];
		for (int i = 0; i < 1000; i++)
			matrix[i] = new Elefant[1000];
		
		ansList = new HashSet<Pair>();
		
		for (int i = 0; i < n; i++)
		{
			String s = br.readLine();
			String vals[] = s.split(" ");
			
			Elefant f = new Elefant();
			
			f.x = Integer.parseInt(vals[0]);
			f.y = Integer.parseInt(vals[1]);
			
			matrix[f.x][ f.y] = f;
			
		}
		
		for (int i = 0; i < 1000; i++)
			for (int j =0; j < 1000; j++)
				if (matrix[i][j]!=null)
				{
					Elefant f = matrix[i][j];
					checkDiagonals(f);
				}
		
		Iterator it = ansList.iterator();
		//for (int i = 0; i < ansList.size(); i++)
		while(it.hasNext())
		{
			Pair p = (Pair) it.next();
			System.out.println(p.x1+" "+p.y1+ " -- "+p.x2+" "+p.y2);
		}
		
		System.out.println(ansList.size()/2);
		
	}
	
	
	public int checkDiagonals(Elefant ef)
	{
		
		int x = ef.x;
		int y = ef.y;
		
		
		int hits = 0;
		for (int i = x+1; i < 1000; i++)
			//for (int j = y + 1; j < 1000; j++)
		{
			
				if (matrix[i][j]!=null)
				{
					//Elefant ef1 = matrix[i][j];
					int x1 = i;
					int y1 = j;
					
					Pair p1 = new Pair();
					p1.x1 = x;
					p1.y1 = y;
					p1.x2 = x1;
					p1.y2 = y1;
					
					ansList.add(p1);
					
					Pair p2 = new Pair();
					p2.x2 = x;
					p2.y2 = y;
					p2.x1 = x1;
					p2.y1 = y1;
					
					ansList.add(p2);
					hits++;
				}
		}
		
		for (int i = x+1; i < 1000; i++)
			for (int j = y - 1; j >= 0; j--)
				if (matrix[i][j]!=null)
				{
					//Elefant ef1 = matrix[i][j];
					int x1 = i;
					int y1 = j;
					
					Pair p1 = new Pair();
					p1.x1 = x;
					p1.y1 = y;
					p1.x2 = x1;
					p1.y2 = y1;
					
					ansList.add(p1);
					
					Pair p2 = new Pair();
					p2.x2 = x;
					p2.y2 = y;
					p2.x1 = x1;
					p2.y1 = y1;
					
					ansList.add(p2);
					hits++;
				}
		
		for (int i = x-1; i >= 0; i--)
			for (int j = y + 1; j < 1000; j++)
				if (matrix[i][j]!=null)
				{
					//Elefant ef1 = matrix[i][j];
					int x1 = i;
					int y1 = j;
					
					Pair p1 = new Pair();
					p1.x1 = x;
					p1.y1 = y;
					p1.x2 = x1;
					p1.y2 = y1;
					
					ansList.add(p1);
					
					Pair p2 = new Pair();
					p2.x2 = x;
					p2.y2 = y;
					p2.x1 = x1;
					p2.y1 = y1;
					
					ansList.add(p2);
					hits++;
				}
		
		for (int i = x-1; i >= 0; i--)
			for (int j = y - 1; j >= 0; j--)
				if (matrix[i][j]!=null)
				{
					//Elefant ef1 = matrix[i][j];
					int x1 = i;
					int y1 = j;
					
					Pair p1 = new Pair();
					p1.x1 = x;
					p1.y1 = y;
					p1.x2 = x1;
					p1.y2 = y1;
					
					ansList.add(p1);
					
					Pair p2 = new Pair();
					p2.x2 = x;
					p2.y2 = y;
					p2.x1 = x1;
					p2.y1 = y1;
					
					ansList.add(p2);
					hits++;
				}
		
		return hits;
	}

	public static void main(String[] args) throws Throwable{

		Solution sol = new Solution();
		
		sol.calc();

	}

}
