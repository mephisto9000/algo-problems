import java.util.Arrays;


public class Solution {
	
	
	// you can write to stdout for debugging purposes, e.g.
	// printf("this is a debug message\n");

	public int solution(int[] A) {
        // write your code in Java SE 8
		
		int[]B = new int[A.length];
		
		for (int i = 0; i < A.length; i++)
			B[i] = A[i];
		
		Arrays.sort(B);
		
		int start = -1;
		int end = -1;
		int n = A.length;
		
		for (int i = 0; i < n; i++)
		{
			if (A[i]!=B[i])
			{
				if (start == -1)
				{
					start = i;
					end = i;
				}
				else
					end = i; 
			}
			
		}
		
		if (start >=0)
			return (end - start + 1);
		
		
		
		return 0;
    }
	

	public static void main(String[] args) {
		

		Solution sol = new Solution();
		
		//int arr[] = {1,2,6,5,5,8,9};
		int arr[] = {1,2,5,5,6,8,9};
		int v = sol.solution(arr);
		System.out.println(v);
		
	}

}
