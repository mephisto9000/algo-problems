package problem189;



import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class Tests {

	
	@Test
	public void test() {
		
		Solution sol = new Solution();
		
		int[] arr = {1,2,3,4,5,6,7}; //  is rotated to .
		int[] exp = {5,6,7,1,2,3,4};
		sol.rotate(arr, 3);
		
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		assertArrayEquals(exp, arr); //sol.rotate(arr, 3));
		//assertEquals( exp, arr);
	}
	

	@Test
	public void test1() {
		
		Solution sol = new Solution();
		
		int[] arr = {1 }; //  is rotated to .
		int[] exp = {1};
		sol.rotate(arr, 1);
		
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		assertArrayEquals(exp, arr); //sol.rotate(arr, 3));
		//assertEquals( exp, arr);
	}
	
	@Test
	public void test2() {
		
		Solution sol = new Solution();
		
		int[] arr = {1 }; //  is rotated to .
		int[] exp = {1};
		sol.rotate(arr, 0);
		
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		assertArrayEquals(exp, arr); //sol.rotate(arr, 3));
		//assertEquals( exp, arr);
	}
	
	
	@Test
	public void test3() {
		
		Solution sol = new Solution();
		
		int[] arr = {1,2 }; //  is rotated to .
		int[] exp = {1,2};
		sol.rotate(arr, 0);
		
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		assertArrayEquals(exp, arr); //sol.rotate(arr, 3));
		//assertEquals( exp, arr);
	}

}
