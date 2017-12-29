package problem287;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class Tests {

	@Test
	 //@Ignore
	public void test() {
		int arr[] = {1,3,4,2,1};
		
		Solution sol = new Solution();
		
		int ans = sol.findDuplicate(arr);
		assertEquals(1, ans);
	}
	
	//[1,5,5,6,2,8,4,7,5,5]
	@Test
	public void test1() {
		int arr[] = {1,5,5,6,2,8,4,7,5,5};
		
		Solution sol = new Solution();
		
		int ans = sol.findDuplicate(arr);
		assertEquals(5, ans);
	}
}
