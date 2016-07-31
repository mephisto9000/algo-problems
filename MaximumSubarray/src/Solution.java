import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	
	int [] sums;
	
	
	public void setup(int arrLen)
	{
		sums = new int[arrLen];
		
		for (int i = 0; i < arrLen; i++)
		{
			sums[i] = 0;
		}
		
		
	}
	
	public int nonContiguousSum(int arrLen, int[] arr)
	{
		setup(arrLen);
		
		//sums[0] = arr[0];
		
		int max = arr[0];
		int lastElement = arr[0]; //Integer.MIN_VALUE;
		
		for (int i = 1; i < arrLen; i++)
		{
			
			if (arr[i] >= lastElement)
			{
				if (max + arr[i] > arr[i])
					max+=arr[i];
				else
					max = arr[i];
				
				lastElement = arr[i];
			}
				
			/*
			if (arr[i-1] <= arr[i])
				sums[i] = sums[i-1]+arr[i];
			else
				sums[i] = arr[i];
			
			if (sums[i] > max)
				max = sums[i]; */
		}
		
		return max;
	}
	
	public int contiguous2(int arrLen, int[] arr)
	{
		if (arr.length <= 0)
			return 0;
		
		int curr_max = arr[0];
		int glob_max = arr[0];
		
		for (int i = 1; i < arrLen; ++i)
		{
			if (curr_max < 0)
				curr_max = arr[i];
			else
				curr_max += arr[i];
			
			if (glob_max < curr_max)
				glob_max = curr_max;
		}
		
		return glob_max;
	}
	
	public int contiguousSum(int arrLen, int[] arr)
	{
		setup(arrLen);
		
		
		//return recContSum(arrLen, arr, 0);
		
		/*
		int curr_max = arr[0];
		int global_max = arr[0];
		
		for (int i = 1; i < arrLen; i++)
		{
			if (arr[i] >= arr[i-1])
				curr_max += arr[i];
			else
				curr_max = arr[i];
			
			if (curr_max > global_max)
				global_max = curr_max;
		}
		
		return global_max;
		*/
		
		
		int curr_max = Integer.MIN_VALUE;
		int global_max = Integer.MIN_VALUE;
		
		for (int i = arrLen-1; i >= 0; i--)
		{
			//sums[i] = arr[i];
			
			
			global_max = arr[i];
			curr_max   = arr[i];
			
			
			if (i < (arrLen -1 ))
			for (int j= i+1; j < arrLen; j++)
			{
				curr_max += arr[j];
				
				if (curr_max > global_max)
					global_max = curr_max;
			} 
			
		  /*
			if (i < (arrLen -1 ))
			{
				if (arr[i] + sums[i+1] > sums[i+1])
						global_max = sums[i+1] + arr[i];
				else
					global_max = sums[i+1];
			
			}
			else
				global_max = arr[i];
				
			sums[i] = global_max; */
		}
		
		global_max = Integer.MIN_VALUE;
		for (int i = 0; i < arrLen; i++)
		{
			if (sums[i] > global_max)
				global_max = sums[i];
		}
		
		return global_max;
		
		
		
	}
	
	/*
	public int recContSum(int arrLen, int[] arr, int rightOffset)
	{
		if (rightOffset >= arrLen)
			return arr[0];
		
		int val = arr[arrLen -1 - rightOffset];
		
		int v1 =  recContSum(arrLen, arr, rightOffset-1);
		int v2 =  recContSum(arrLen, arr, rightOffset-1) + val;
		
		if (v1 >= v2)
			return v1;
		else return v2;
	} */
	
	
	public static void main(String[] args) throws IOException
	{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//BufferedReader br = new BufferedReader(new FileReader("bhah.blah"));
	Solution sol = new Solution();
	
	int testNum = Integer.parseInt(br.readLine());
	for (int i = 0; i < testNum; i++)
	{
		int elementsNum = Integer.parseInt(br.readLine());
		int[] elements = new int[elementsNum];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int j = 0;
		while (st.hasMoreTokens())
		{
			int val = Integer.parseInt(st.nextToken());
			elements[j] =   val;
			j++;
		}
		
		System.out.print(sol.contiguous2(elementsNum, elements));
		System.out.print(' ');
		System.out.println(sol.nonContiguousSum(elementsNum, elements));
		
		
	}
	
	}
}
