package problem54;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class Tests {

	@Test

	public void test() {
		Solution sol = new Solution();
		
		int [][]matrix = {	{1,2,3},
							{4,5,6},
							{7,8,9}
						}; 
		
		
		
		int[] exp1 = {1,2,3,6,9,8,7,4,5};
		
		List<Integer> exp  = null;
		
		exp =   Arrays.asList(1,2,3,6,9,8,7,4,5);
		
		assertEquals(exp, sol.spiralOrder(matrix));
		
	}
	
	
	@Test

	public void test1() {
		Solution sol = new Solution();
		
		int [][]matrix = {	{1,2,3}
							 
						}; 
		
		
		
		//int[] exp1 = {1,2,3,6,9,8,7,4,5};
		
		List<Integer> exp  = null;
		
		exp =   Arrays.asList(1,2,3);
		
		assertEquals(exp, sol.spiralOrder(matrix));
		
	}
	
	@Test

	public void test2() {
		Solution sol = new Solution();
		
		int [][]matrix = {	{2,3}
							 
						}; 
		
		
		
		//
		
		List<Integer> exp  = null;
		
		exp =   Arrays.asList(2,3);
		
		assertEquals(exp, sol.spiralOrder(matrix));
		
	}
	
	@Test
	
	public void test3() {
		Solution sol = new Solution();
		
		int [][]matrix = 	{{1,2,3,4},
							{5,6,7,8},
							{9,10,11,12},
							{13,14,15,16}};
		
		
		
		//
		
		List<Integer> exp  = null;
		
		exp =   Arrays.asList(1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10);
		
		assertEquals(exp, sol.spiralOrder(matrix));
		
	}
	
	@Test	
	public void test4() {
		Solution sol = new Solution();
		
		int [][]matrix =  {{1,2,3,4},
						   {5,6,7,8},
						   {9,10,11,12}};
		
		
		
				
		
		List<Integer> exp  = null;
		
		exp =   Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7);
		
		assertEquals(exp, sol.spiralOrder(matrix));
		
	}
	
	
}
