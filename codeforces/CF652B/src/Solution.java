import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] vals = br.readLine().split(" ");
		
		//int[] arr = new int[n];
		
		LinkedList<Integer> arr = new LinkedList<Integer>();
		
		
		for (int i = 0; i < n; i++)
			arr.add(Integer.parseInt(vals[i]));
		
		
		
			
			//arr[i] = Integer.parseInt(vals[i]);
			
		
		Collections.sort(arr);
		
		int a = 0;
		int z = n-1;
		
		int i = 0;
		
		StringBuffer sb = new StringBuffer();
		 
		while(!arr.isEmpty())
		{
			i++;
			
			if (i % 2 == 0)
			{
				sb.append(arr.removeLast());
				sb.append(" ");
			}
			else
			{
				sb.append(arr.remove(0));
				sb.append(" ");
			}
			
			
		}
		
		//int mid = n/2;
		
		/*
		for (int i = 0; i < n/2; i++)
		{
			if ((i+1) % 2 == 0)
			{
				int v = arr[mid + i];
				arr[mid + i] = arr[i];
				arr[i]  = v;
			}
			//mid++;
		} */
		
		
		
		
		
		
		
		
		System.out.println(sb.toString().trim());
		
		
	}
	

	public static void main(String[] args) throws Exception {
		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
