package attempt2;

import java.util.Arrays;

public class Solution {
	
	char arr[]; 

	public void calc(char[] out_arr)
	{
		
		arr = out_arr;
		
		Arrays.sort(arr);
		
		int n = arr.length;
		
		prettyprint();
		
		while(true)
		{
			boolean stop = true;
			for (int i = arr.length-1; i >0; i--)
			{
				
				if (arr[i-1]< arr[i])
				{
					stop = false;
					
					int max_i = i;
					
					for (int j = i; j < n; j++)
					{
						if (arr[j] > arr[i-1])
							max_i = j;
					}
					
					swap(i-1, max_i);
					
					rotate (i, n-1);
					
					prettyprint();
					
					break;
				}
			}
			
			if (stop)
				break;
		}
	}
	
	void prettyprint()
	{
		
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]+" ");
			
		}
		
		System.out.println();
	}
	
	void swap (int i, int j)
	{
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	void rotate(int i, int j)
	{
		int n = arr.length;
		char[] tmp = new char[n];
		
		for (int a = 0; a < n; a++)
			tmp[a] = arr[a];
		
		int y = j;
		for (int z = i; z <=j; z++)
		{
			arr[z] = tmp[y];
			y--;
		}
	}
	
	public static void main(String[] args) {
		
		
		
		char[] my_arr = {'c', 'a', 'b', 'z'};  //{'a','z','v', 'x', '5', '*', '?'};
		
		Solution sol = new Solution();
		
		sol.calc(my_arr);

	}

}
