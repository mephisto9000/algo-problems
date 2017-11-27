package problem84;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.Test;

public class Tests {

	
	@Test
	public void testA() throws Exception {
		int arr[] = {2,1,5,6,2,3};
		
		Solution  sol = new Solution();
		
		int ans = sol.largestRectangleArea(arr);
		int exp = 10;
		
		assertEquals(exp, ans);
	}
	/*
	@Test
	public void test0() throws Exception {
		int arr[] = {2,1,5,6,2,3};
		
		SolutionSegTree sol = new SolutionSegTree();
		
		int ans = sol.largestRectangleArea(arr);
		int exp = 10;
		
		assertEquals(exp, ans);
	}
	

	@Test
	public void test1() throws Exception {
		int arr[] = {4,2};
		
		SolutionSegTree sol = new SolutionSegTree();
		
		int ans = sol.largestRectangleArea(arr);
		int exp = 4;
		
		assertEquals(exp, ans);
	}
	
	
	*/
	
	@Test
	public void test() throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader("/Volumes/media HD/projects/interview workspace/LeetCode/src/problem84/t1.txt"));
		
		ArrayList al = new ArrayList();
		
		for (int i = 0; i < 1000; i++)
		{
			String s = br.readLine();
			al.add(Integer.parseInt(s));
		}
		//Arrays.
		//List<Integer> list = ...;
		int[] array = new int[al.size()];
		for(int i = 0; i < al.size(); i++) 
			array[i] = (Integer) al.get(i);
		Solution  sol = new Solution ();
		int ans = sol.largestRectangleArea(array);
						
		assertEquals(883333412, ans);
	} 
	
	
	
	 
}
