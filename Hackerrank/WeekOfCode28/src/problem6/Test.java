package problem6;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() throws Exception{
		Solution sol = new Solution();
		
		sol.src = "p6t1.txt";
		
		int[] arr = sol.calc();
		
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
				
		
		assertArrayEquals(new int[]{0,1,2}, arr);
	}

}
