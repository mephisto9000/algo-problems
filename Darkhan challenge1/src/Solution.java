
public class Solution {
	
	
	
	public int calcOnes(int n, int step )
	{
		
		//% - remainder
		// / - div 
		int result = 0;
		
		if (n == 0)
			return 0;
		
		//int x = (int) Math.pow(10, step);
		
		int curDiv = String.valueOf(n).length()-1;
		curDiv = (int) Math.pow(10, curDiv);
		

		
		int smallestTen = (n / curDiv);
		
				
		 result = calcOnes(n/10, step+1 );
		
		if (smallestTen >= 1)
		{
			//n / x
			
			result += 1 +
			
			return (calcOnes(n/10, step+1 )*10 + 1);
		}
		else
			return (calcOnes(n/10, step+1) * 10);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution sol = new Solution();
		sol.calcOnes(11, 1);
	}

}
