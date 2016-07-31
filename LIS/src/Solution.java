import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;


public class Solution {
	
	int n;
	int vals[]; 
	
	public Solution(int n)
	{
		super();
		this.n = n;
		this.vals = new int[n];
	}
	
	public void addValue(int index, int value)
	{
		vals[index] = value;
	}
	
	public int calcNSquare()
	{
		
		
		int dp[] = new int[n];
		
		dp[0] = 1;
		
		for (int i = 1; i < n; i++)
		{
			dp[i] = 1;
			
			for (int j = 0; j < i; j++)
			{
				if (vals[i] > vals[j] && dp[i] < dp[j]+1)
					dp[i] = dp[j] + 1;
			}
		}
		
		int lis = dp[0];
		
		for (int i = 1; i < n; i++)
			if (dp[i] > lis )
				lis = dp[i];
			
		
		
		return lis;
	}
	
	public int calcNLogn()
	{
		int sz = 1;
		int c[] = new int[n];
		int dp[] = new int[n];
		c[1] = vals[0];
		
		for (int i = 1; i < n; i++)
		{
			if (vals[i] < c[1])
			{
				c[1] = vals[i];
				dp[i] = 1;
			}
			else if (vals[i] > c[sz]) 
			{
				c[sz+1] = vals[i];
				dp[i] = sz + 1;
				sz ++;
			}
			else {
				int k = binarysearch(c, 0, sz -1, vals[i], sz-1);
				c[k] = vals[i];
				dp[i] = k;
			}
				
		}
		
		int lis = dp[0];
		
		for (int i = 1; i < n; i++)
			if (dp[i] > lis )
				lis = dp[i];
			
		
		
		return lis;
		
		
	}
	
	private int binarysearch(int[] arr, int start, int len, int target, int arrlen)
	{
		//if (start > len)
		//	return len;
		
		
		System.out.println("start=="+start+", len == "+len+", target=="+target+" arrlen=="+arrlen);
		/*
		if (len - start == 0 )
		{	
			
			if (arr[start] >= target)
			{
				if (start > 0 && arr[start-1] < target) 
					return start;
				else 
				
					return start;
			} 
			
			else return -1; 
			
		} */
		
		
		if (len - start == 0)
		{
			if (arr[start] >= target && arr[start-1] < target) 
				return start;
			//else
			//if (arr[len] >= target) // && arr[start-1] < target) 
			//	return len;
			
			if (arr[start] <= target && start == arrlen )
				return start;
			
			else
				return -1;
		}
		
		
		if (len - start == 1)
		{
			if (arr[start] < target && arr[len] >= target)
				return len;
			else
			if (arr[len] <= target && len == (arr.length -1)) // && arr[start-1] < target) 
				return len;
			else
			if (arr[len] < target && arr[len+1]>=target)
				return len;
			else
			if (arr[start]>=target && arr[start-1] < target)
				return start;
			
			else
				return -1;
		}
			
		
		
		int middle = ((int) ((len - start) / 2)) + start;
		
		for (int i = 0; i <= len; i++)
			System.out.println("val "+i+" == "+arr[i]);
		
		// if (middle == start)
		//	 middle++;
		
		
		//System.out.println("start = "+start+", middle = "+middle+", end = "+len+", target="+target);
		int solution = -1;
		if (middle < target)
			solution = binarysearch(arr, start, middle, target, arrlen);
		//else
		if (middle >= target || solution == -1)
			solution = binarysearch(arr, middle+1, len, target, arrlen);
		
		return solution;
	}
	
	
	
	public static <E extends Comparable<? super E>> void sort (E[] n)
    {
        List<Pile<E>> piles = new ArrayList<Pile<E>>();
        // sort into piles
        for (E x : n)
        {
            Pile<E> newPile = new Pile<E>();
            newPile.push(x);
            int i = Collections.binarySearch(piles, newPile);
            if (i < 0) i = ~i;
            if (i != piles.size())
                piles.get(i).push(x);
            else
                piles.add(newPile);
        }
        System.out.println(piles.size());
 
        // priority queue allows us to retrieve least pile efficiently
        PriorityQueue<Pile<E>> heap = new PriorityQueue<Pile<E>>(piles);
        for (int c = 0; c < n.length; c++)
        {
            Pile<E> smallPile = heap.poll();
            n[c] = smallPile.pop();
            if (!smallPile.isEmpty())
                heap.offer(smallPile);
        }
        assert(heap.isEmpty());
    }
	
	
	 private static class Pile<E extends Comparable<? super E>> extends Stack<E> implements Comparable<Pile<E>>
	    {
	        public int compareTo(Pile<E> y) { return peek().compareTo(y.peek()); }
	    }
	    
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader (new FileReader("input2.txt"));
		
		int n = Integer.parseInt(br.readLine());
		int val;
		Solution sol = new Solution(n);
		
		Integer[] vals = new Integer[n];
		
		for (int i = 0; i < n; i++)
		{
			 val = Integer.parseInt(br.readLine());
			 
			 //sol.addValue(i, val);
			 vals[i] = new Integer(val);
			 
		}
		
		sol.sort(vals);
		
		//System.out.println(sol.calcNLogn());
		//System.out.println(sol.calcNSquare());
	}

}
