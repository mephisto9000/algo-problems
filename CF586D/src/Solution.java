import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	int width = 0;
	int height = 0;
	
	//int [] trainStart;
	//int [] trainSize;
	
	char[][] field;
	
	
	int initX = 0;
	int initY = 0;
	
	int[][] memo;
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		
		int t = Integer.parseInt(br.readLine());
		String[] vals;
		
		
		
		for (int i = 0; i < t; i++)
		{
			vals = br.readLine().split(" ");
			
			width = Integer.parseInt(vals[0]);
			
			memo = new int[3][];
			
			
			
			
			int trainCount = Integer.parseInt(vals[1]); 
					
			height = 3; //Integer.parseInt(vals[1]);
			
			
			
			//trainStart = new int[trainCount];
			//trainSize = new int[trainCount];
			
			field = new char[3][];
			
			
			
			//Arrays.fill(trainStart, 0);
			//Arrays.fill(trainSize, 0);
			
			for (int j = 0 ; j < height; j++)
			{
				String s = br.readLine()+"..";
				
				memo[j] = new int[width+2];
				
				Arrays.fill(memo[j], -1);
				
				field[j] = s.toCharArray();
				
				if (s.startsWith("s"))
				{
					initX = 0;
					initY = j;
				}
				
				 
			}
			
			if (rec(initX, initY))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
	private boolean rec(int x, int y) {
							
		
		if (memo[y][x] != -1)
		{
			int v = memo[y][x];
			
			if (v == 0)
				return false;
			else
				return true;
		}
			
		
		if (field[y][x]!='.' && field[y][x]!='s')
			return false;
		
		
		if (x >= width-1)
			return true;
		
		
		
		
		
		// the cell is fine
		
		x++;
		
		if (memo[y][x] != -1)
		{
			int v = memo[y][x];
			
			if (v == 0)
				return false;
			else
				return true;
		}
		
		
		
		if (field[y][x]!='.' && field[y][x]!='s')
			return false;
		
		if (x >= width-1)
			return true;
		
		
		
		//top iskilled ?
		boolean aliveTop = false;
		
		if (y > 0 && field[y-1][x]=='.') 
		{
			if (field[y-1][x+1]=='.' && field[y-1][x+2]=='.')
			{
				if (memo[y-1][x+2] != -1)
				{
					int v = memo[y-1][x+2];
					
					if (v == 0)
						aliveTop = false;
					else
						aliveTop = true;
				}
				else
				
				
				aliveTop =  rec(x+2, y-1);
			}
										
		}
		
		if (aliveTop) 
		{
				memo[y][x-1] = 1; 
				return true;
		}
		
		
		boolean aliveMiddle = false;
		
		
		{
			
			if (field[y][x+1]=='.' && field[y][x+2]=='.')
			{
				if (memo[y][x+2] != -1)
				{
					int v = memo[y][x+2];
					
					if (v == 0)
						aliveTop = false;
					else
						aliveTop = true;
				}
				else					
				 aliveMiddle = rec(x+2, y);
			}
		}
		
		if (aliveMiddle) {
			memo[y][x-1] = 1; 
			return true;
		}
		 
	
		boolean aliveBtm = false;
	
		
		if (y < height - 1 && field[y+1][x]=='.')
		{
			if (field[y+1][x+1]=='.' && field[y+1][x+2]=='.')
				if (memo[y+1][x+2] != -1)
				{
					int v = memo[y+1][x+2];
					
					if (v == 0)
						aliveTop = false;
					else
						aliveTop = true;
				}
				else
				aliveBtm = rec(x+2, y+1);			
		}
		
		if (aliveBtm) {
			memo[y][x-1] = 1; 
			return true;
		}
		//else
			//aliveBtm = false;
		
		memo[y][x-1] = 0;
		return false;
	}

	public static void main(String[] args) throws Exception{

		Solution sol = new Solution();
		sol.calc();

	}

}