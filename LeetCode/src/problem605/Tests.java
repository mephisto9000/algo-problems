package problem605;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		Solution sol = new Solution();
		int arr[] = {0,1,0};
		assertFalse(sol.canPlaceFlowers(arr, 1));
		 
	}

}
