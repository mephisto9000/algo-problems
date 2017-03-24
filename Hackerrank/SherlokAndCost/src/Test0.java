import static org.junit.Assert.*;

import org.junit.Test;

public class Test0 {

	@Test
	public void test0() throws Exception {
		Solution sol = new Solution();
		
		sol.src = "test0.txt";
		int arr[] = {1121,642, 508, 1107, 5563, 5012 ,4858, 4256, 3585, 1228, 2849, 1709,
					4550, 2603, 0, 3264, 3949, 0, 3242, 1888};
		assertArrayEquals(arr, sol.calc());
	}

}
