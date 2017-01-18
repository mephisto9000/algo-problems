package problem4;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() throws Exception {
		
		Solution sol = new Solution();
		
		sol.src = "p4t1.txt";
		String[] arr = sol.calc();
		
		assertArrayEquals(new String[] {"32"}, arr);
	}
	
	@org.junit.Test
	public void test1() throws Exception {
		
		Solution sol = new Solution();
		
		sol.src = "p4t2.txt";
		String[] arr = sol.calc();
		
		assertArrayEquals(new String[] {"352"}, arr);
	}
	
	@org.junit.Test
	public void test2() throws Exception {
		
		Solution sol = new Solution();
		
		sol.src = "p4t3.txt";
		String[] arr = sol.calc();
		
		assertArrayEquals(new String[] {"16"}, arr);
	}
	
	@org.junit.Test
	public void test3() throws Exception {
		
		Solution sol = new Solution();
		
		sol.src = "p4t4.txt";
		String[] arr = sol.calc();
		
		assertArrayEquals(new String[] {"20"}, arr);
	}
	
	@org.junit.Test
	public void test4() throws Exception {
		
		Solution sol = new Solution();
		
		sol.src = "p4t5.txt";
		String[] arr = sol.calc();
		
		assertArrayEquals(new String[] {"24"}, arr);
	}
	
	@org.junit.Test
	public void test5() throws Exception {
		
		Solution sol = new Solution();
		
		sol.src = "p4t6.txt";
		String[] arr = sol.calc();
		
		assertArrayEquals(new String[] {"32", "352", "16", "20", "24"}, arr);
	}
	
	
	@org.junit.Test
	public void test6() throws Exception {
		
		Solution sol = new Solution();
		
		sol.src = "p4t7.txt";
		String[] arr = sol.calc();
		
		assertArrayEquals(new String[] {"24"}, arr);
	}

}
