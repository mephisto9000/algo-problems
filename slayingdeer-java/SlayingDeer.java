public class SlayingDeer {

	public int getTime(int A, int B, int C) {
		
		
		int ad = 0;
		int bd = C;
		
		int t = 0;
		int tt = 0;
		
		int coolt = 0;
		
		while (ad < bd)
		{
			ad += A;
			
			if (coolt == 0)
			{
				bd += B;
				t++;
			}
			else
				coolt --;
			
			
			tt ++;
			
			if (t  == 30  && coolt == 0)
			{
				t = 0;
				coolt = 15;
			}
			
			if (tt > 10000000)
				return -1;
			
			
		}
		
		return tt;

	}

}
