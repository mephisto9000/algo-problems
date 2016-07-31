import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
	
	int[] memo;
	boolean[] u;
	
	public class Platform{
		public int start;
		public int end;
		
		
		public Platform(int start, int end)
		{
			this.start = start;
			this.end = end;
			memo = new int[101];
			u = new boolean[101];
			Arrays.fill(memo, -1);
			Arrays.fill(u, false);
		}
		
	}
	
	List<Platform> ladders;
	List<Platform> snakes;
	
	public Solution()
	{
		ladders = new ArrayList<Platform>();
		snakes = new ArrayList<Platform>();
	}
	
	
	public void addLadder(int start, int end)
	{
		Platform p = new Platform(start, end);
		ladders.add(p);
	}
	
	public void addSnake(int start, int end)
	{
		Platform p = new Platform(start, end);
		snakes.add(p);
	}
	
	
	public int calc(int startPos)
	{
		
		//System.out.println("startPos == " + startPos);
		if (startPos > 100)
			return Integer.MAX_VALUE;
		
		if (startPos == 100)
			return 0;
		
		if (memo[startPos] != -1)
			return memo[startPos];
		int pos = startPos;
		
		for (int i = 0; i < snakes.size(); i++)
		{
			if (snakes.get(i).start == startPos) 
				if (u[startPos] == false)
				{
				u[startPos] = true;
				int res = calc(snakes.get(i).end);
				memo[startPos] = res;
				return res;
				}
				else
				{
					return Integer.MAX_VALUE;
				}
			
		}
		
		for (int i = 0; i < ladders.size(); i++)
		{

			if (ladders.get(i).start == startPos)
				if ( u[startPos] == false)
			{
				u[startPos] = true;
				int res = calc(ladders.get(i).end);
				memo[startPos] = res;
				return res;
			}
				else
					return Integer.MAX_VALUE;
		}
		
		u[startPos] = true;
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= 6; i++)
		{
			int temp = calc(startPos + i);
			
			//if (temp  Integer.MAX_VALUE)
				//temp += i;
			min = Math.min(min, temp);
		}
		
		
		if (min == Integer.MAX_VALUE)
		{
			memo[startPos] = min;
			return min;
		}
		else
		{
			memo[startPos] = min + 1; 
			return min + 1;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		
		int tests = Integer.parseInt(br.readLine());
		
		
		
		for (int i = 0; i < tests; i++)
		{
			
			Solution sol = new Solution();
			
			int laddersNum = Integer.parseInt( br.readLine());
			
			for (int j = 0; j < laddersNum; j++)
			{
				String[] ladder = br.readLine().split(" ");
				sol.addLadder(Integer.parseInt(ladder[0]), Integer.parseInt(ladder[1]));
			}
			int snakeNum = Integer.parseInt(br.readLine());
			for(int j = 0; j < snakeNum; j++)
			{
				String[] snake = br.readLine().split(" ");
				sol.addSnake(Integer.parseInt(snake[0]), Integer.parseInt(snake[1]));
			}
			
			int res = sol.calc(1);
			if (res < Integer.MAX_VALUE)
			System.out.println(res);
			else
				System.out.println(-1);
				
		}

	}

}
