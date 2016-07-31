import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	//List<Integer> primes;
	boolean[] prime;
	List<String>[] pres;
	List<Integer> primesonly;
	
	
	public void fillPrimes()
	{
	int n = 32000;
	//vector<char> prime (n+1, true);
	prime = new boolean[32001];
	primesonly = new ArrayList<Integer>();
	Arrays.fill(prime, true);
		
	prime[0] = prime[1] = false;
	for (int i=2; i<=n; ++i)
		if (prime[i])
			if (i *  i <= n)
				for (int j=i*i; j<=n; j+=i)
					prime[j] = false;
	
	//int z = 0;
	for (int i=0; i<=n; ++i)
	{
		if (prime[i] == true)
			primesonly.add(i);
	}
	
	}
	
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		
		int n = Integer.parseInt(br.readLine());
		
		fillPrimes();
		
		
		pres = new ArrayList[32002];
		
		for(int i = 0; i < prime.length  ; i++)
		{		
			pres[i] = new ArrayList<String>();
		}
		
		/*
		for(int i = 0; i < prime.length / 2; i++)
		{		
			//pres[i] = new ArrayList<String>();
			
			if (prime[i]==true)
			{
			for(int j = i; j < prime.length; j++)
				if (prime[j] ==true && ((i + j) <= 32000))
				{
					if (pres[i+j] == null)
						pres[i+j] = new ArrayList<String>();
					
					pres[i+j].add((i)+"+"+(j));
					
					//System.out.println((i+1)+"+"+(j+1));
				}
			}
		}  */
		
		//System.out.println("here");
		/*
		for (int i = 0; i < primesonly.size() / 2; i++)
		{
			
			int idxi = primesonly.get(i);
			for (int j = i; j < primesonly.size(); j++)
			{
				
				
				
				int idxj = primesonly.get(j);
				
				if (idxi + idxj > 32000)
					break;
				
				pres[idxi + idxj].add(idxi + "+" + idxj);
			}
		}*/
		
		//System.out.println("there");
		
		for (int i = 0; i < n; i++) //n
		{
			int v =  Integer.parseInt(br.readLine());
			
			for (int j = 0; j < (v /2) +1; j++)
			{
				if (prime[j] == true && prime[v-j] == true)
				{
					pres[v].add(j + "+"+ (v-j));
				}
			}
			
			System.out.println(String.format("%d has %d representation(s)", v, pres[v].size()));
			for (int j = 0; j < pres[v].size(); j++)
				System.out.println(pres[v].get(j));
			
			System.out.println();
		}
		
	}

	public static void main(String[] args) throws Exception {
		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
