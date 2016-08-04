import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		
		int n = Integer.parseInt(br.readLine());
		
		List<Long> even = new LinkedList<Long>();
		List<Long> odd = new LinkedList<Long>();
		
		String vals[] = br.readLine().split(" ");
		for (int i = 0; i< n; i++)
		{
			Long v = Long.parseLong(vals[i]);
			
			if (v % 2 == 0)
				even.add(v);
			else
				odd.add(v);
		}
		
		BigInteger res = BigInteger.ZERO;
		
		for (Long v : even)
		{
			//res += v;
			res = res.add(BigInteger.valueOf(v));
		}
		long[] oddarr = new long[odd.size()];
		
		int i = 0;
		for (long v : odd)
		{
			oddarr[i] = v;
			i++;
		}
		Arrays.sort(oddarr);
		
		for (int j = oddarr.length-1; j >=0; j-=2)
		//for (int j = 0; j < oddarr.length; j+=2)
		{
			long summ = 0;
			//if (j < oddarr.length && j+1 <oddarr.length)
			if (j >= 0 && j-1 >=0)
			{	
			summ = oddarr[j];
			
				summ += oddarr[j-1];
			}
			//res += summ;
			
			res = res.add(BigInteger.valueOf(summ));
		}
		
		System.out.println(res);
		
		
		
		
	}
	

	public static void main(String[] args) throws Exception{

		Solution sol = new Solution();
		sol.calc();

	}

}
