import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	private int n;
	private int k;

	private int[][] prices;
	
	private int[][] tprices;
	
	private int[][] memo;
	
	public class Card{
		public  int ii;
		public int jj ;
		public int price;
		public Card nextCard = null;
		
		public Card(int ii, int jj, int price)
		{
			super();
			this.ii = ii;
			this.jj = jj;
			this.price = price;
		}
	}
	
	Comparator<Card> comp = new Comparator<Card>()
	{
		
		public int compare(Card o1, Card o2) {
			
			if (o1.price > o2.price)
				return 1;
			
			if (o1.price < o2.price)
				return -1;
			
			return 0;
		}
		
	};
	
	

	public Solution(int n, int k)
	{
		super();
		this.n = n;
		this.k = k;
	}

	public void setPrices(int[][] prices)
	{
		this.prices = prices;
	}

	public int calc()
	{
		tprices = new int[n][k];
		memo = new int[n][k];

		// transpose
		for (int i = 0; i < k; i++)
		{
			for (int j = 0; j < n; j++)
			{
				tprices[j][i] = prices[i][j];
				memo[j][i] = -1;
			}
		}
	
		return rec (new HashSet<Integer>(), 0, -1);

	}
	
	public Card rec ( int cur_i,  int prev)
	{
		if (cur_i >= n )
			return 0;
		
		
		PriorityQueue<Card> q = new PriorityQueue<Card>(k, comp);
		for (int j = 0; j < k; j++)
			q.add(new Card(cur_i,j, tprices[cur_i][j]));
		
		
		int currentSumm = Integer.MAX_VALUE;
		
		//List<Integer> ans = new LinkedList<Integer>();
		int minAns = Integer.MAX_VALUE;
		Card minCard = null;
		
		for (int j = 0; j < k; j++)
		{								
			Card c =   q.poll(); //arr[j];

			//System.out.println("i = "+c.ii+" j = "+c.jj+" price = "+c.price);
			
			if (( prev == c.jj )) // && currentSumm >= c.price)
			{
				
				// System.out.println("i="+c.ii+" j="+c.jj+", price="+c.price);
				// cur_i += c.price;
				// prev = c.jj;
				h.add(c.jj);
				int loc_prev = c.jj;
				
				currentSumm = c.price;
				//if (minAns < )
				int ans;

				
				if (memo[cur_i+1][loc_prev] == -1)
				{
					minCard = rec( cur_i +1, loc_prev);
					ans = currentSumm + calcPriceFromList(rec( cur_i +1, loc_prev));
					memo[cur_i][j] = ans;
				}
				else 
					ans = memo[cur_i+1][loc_prev];
				
				if (minAns > ans)
					minAns = ans;
				
				if (prev != c.jj)
					h.remove(c.jj);
				
				//minAnd.add (currentSumm + rec(h, cur_i +1, prev));
				
				//break;
			}
		}
		
		return minAns;
	}
	
	public int calcPriceFromList(Card c)
	{
		int result = 0;
			
		while (c != null)
		{
			result += c.price;
			c = c.nextCard;
		}
		
		return result;
		
		
	}

	public static void main(String[] args) throws IOException 
	{
		BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader sb = new BufferedReader(new FileReader(new File("case1.txt")));

		String s = sb.readLine();

		StringTokenizer st = new StringTokenizer(s);
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Solution sol = new Solution(n, k);

		int [][] prices = new int[k][n];

		for (int i = 0; i < k ; i++)
		{
			s = sb.readLine();
			st = new StringTokenizer(s);

			for (int j = 0; j <  n; j++)
			prices[i][j] = Integer.parseInt(st.nextToken());

		}


		sol.setPrices(prices);

		System.out.println(sol.calc());


	}
}