public class CountGame {
	
	boolean isInit = false;
	int calcs[];

	public int howMany(int maxAdd, int goal, int next) {
		
		if (isInit == false)
		{
			calcs = new int[goal+1];
			
			for (int i = 0; i < goal; i++)
			{
				calcs[i+1] = -2;
			}
			
			isInit = true;
		}
		
		if (calcs[next] != -2)
			return calcs[next];
		
		//if (goal - next)
		int steps = goal - next;
		
		if ((steps  < maxAdd)  && (steps  >= 0))
		{
			calcs[next] = goal - next + 1; // (steps - maxAdd);
			//return (steps - maxAdd);
			return calcs[next];
		}
		
		
		for (int i = 0; i < maxAdd; i++)
		{
			int nextResult = howMany(maxAdd, goal, next +(i+1));
			
			if (nextResult == -1)
			{
				calcs[next] = i+1;
				return calcs[next];
			}
		}
		
		//return 0;
		calcs[next] = -1;
		return -1;
	}
	
	
	public static void main(String[] args)
	{
		 int maxAdd = 3;
	        int goal = 20;
	        int next = 10;

	        int expected = 3;
	        
	     CountGame solution = new CountGame();
	     int actual = solution.howMany(maxAdd, goal, next);
	     System.out.println(actual);
	}

}
