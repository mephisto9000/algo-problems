import java.util.LinkedList;
import java.util.List;

public class Solution {

	
	/*
	param1 = {1,2,3,0} param2 = {3,2,1,0}

	{1,2,0,3} =>  “car 3 moved from pos 3 to 4”
	{1,0,2,3}
	{0,1,2,3}


	1 2 3 0   => 0 1 2 3

	move 2   move 1   move3    move2    
	1 0 3 2, 0 1 3 2, 2 1 3 0, 2 1 0 3, 0 1 2 3  

	1 0  => 0 1

	1 2 0  => 2 1 0

	move1,   move2   move1
	0 2 1    2 0 1   2 1 0
	*/

	public void moveCars(int[] initial, int[] desired ) throws Exception
	{
		//if (initial.length != desired.length)
		//	throw new Exception(“not allowed”);

	 
		
	int n = initial.length;
	while (true)
	{
	   
		boolean stop = false;
	for (int i = 0; i < n; i++)
	{
		
		
	if (initial[i]!=desired[i])
	{
	int spot = 0;

	stop = true;

		for (int j = 0; j < n; j++)
	{
			if (initial[j] == 0)
				{
					spot = j;
					break;
				}
		}

		
		int carTo = -1;
		
		for (int j = 0; j < n; j++)
		{
			if (desired[j] == initial[i])
	{
		carTo = j;
		break;
	}
		}

		//swap(i, spot);  // move car to spot
		
		initial[spot] = initial[i];
		
		//carTo =initial[i]
		initial[i] = initial[carTo];
		//swap(i, carTo);  // move car from destination pos to opened spot	
		
		initial[carTo] = initial[spot];
		//swap(spot, carTo); // move car to destination; 
		
		initial[spot] = 0;

		

		
		

	}	
	}	
	
	if (stop )
		break;
	

	}
	

		//return log;
	
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++)
		{
			sb.append(initial[i]);
			sb.append(' ');
		}
		
		System.out.println(sb.toString());
	}


	
	public static void main(String[] args) throws Exception {
		
		
		Solution sol = new Solution();
		
		int[] a = {1,2,3,0};
		int []b= {0,1,2,3};
		sol.moveCars(a, b);

	}

}
