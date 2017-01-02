import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	
	void swap(char[] a, int i, int j)
	{
		char c = a[i];
		
		a[i] = a[j];
		
		a[j] = c;
	}
	
	void quicksort(char a[], int start, int end)
	{
		int mid = (start + end) / 2;
		char pivot = a[mid];
		
		int i = start;
		int j = end;
		
		while( i <= j)
		{
			while (a[i] < pivot)
			{
				i++;
			}
			
			while(a[j] > pivot)
			{
				j--;
			}
			
			if (i <= j)
			{
				swap(a, i, j);
				i++;
				j--;
			}
		}
		
		if (start < j)
			quicksort(a, start, j);
		if (i < end)
			quicksort(a, i, end);

	}
	
	
	public boolean[] calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		boolean arr[] = new boolean[t];
		
		//System.out.println(t);
		
		for (int i = 0; i < t; i++)
		{
			
			int n = Integer.parseInt(br.readLine());
			
			char[][] mtx = new char[n][n];
			
			
			
			
			for (int j = 0; j < n; j++)
			{
				mtx[j] = br.readLine().toCharArray();
				quicksort(mtx[j], 0, n-1);
			}
			
			boolean ans = true;
			for (int j = 0; j < n; j++)
			{
				for (int i1 = 0; i1 <n-1; i1++)
				{
					if (mtx[i1][j] > mtx[i1+1][j])
					{
						ans = false;
						break;
					}
				}
				
				if (ans == false)
					break;
			}
			
			arr[i] = ans;
			
		}
		
		return arr;
	}
	

	public static void main(String[] args) throws Exception{


		Solution sol = new Solution();
		boolean[] arr = sol.calc();
		for (int i = 0; i < arr.length; i++)
		{
		if (arr[i])
			System.out.println("YES");
		else
			System.out.println("NO");
		}

	}

}
