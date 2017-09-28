package interview1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		
		Problem1 p = new Problem1();
		
		int nums[] = {5, 1, 2, 6, 20, 2};
		
		int exp = 27;
		
		int ans = p.calc(nums);
		
		assertEquals(exp, ans);
	}
	/*
	 self.arr1 = [5, 1, 2, 6, 20, 2]
		        self.arr2 = [53, 1, 12, 65, 200, 2, 7, 90, 100, 54]
		        self.arr3 = [1, 2, 3, 4]
		        self.arr4 = [1, 1, 1, 1] */
	
	/*
	@Test
	public void test1() {
		
		Problem1 p = new Problem1();
		
		int nums[] = {53, 1, 12, 65, 200, 2, 7, 90, 100, 54};
		
		int exp = 372;
		
		int ans = p.calc(nums);
		
		assertEquals(exp, ans);
	}
	*/
	
	//self.arr4 = [1, 1, 1, 1] */
			
	@Test
	public void test5() {
				
				Problem1 p = new Problem1();
				
				int nums[] = {1,1,1,1};
				
				int exp = 2;
				
				int ans = p.calc(nums);
				
				assertEquals(exp, ans);
	}
	
	
	@Test
	public void test3() {
		
		Problem1 p = new Problem1();
		
		int nums[] = {53, 1, 12, 65, 200, 2, 7, 90, 100, 54};
		
		int exp = 372;
		
		int ans = p.calc(nums);
		
		assertEquals(exp, ans);
	}
	
	
	
	@Test
	public void test4() {
		
		Problem1 p = new Problem1();
		
		int nums[] = {1,2,3,4};
		
		int exp = 6;
		
		int ans = p.calc(nums);
		
		assertEquals(exp, ans);
	}
}
