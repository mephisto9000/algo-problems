package C;


import java.io.BufferedReader;
import java.io.InputStreamReader;
 

public class Solution {
	
	int n;  //рядов
	int m;  //колон
	long k;  //вопросов
	int x;  //ряд сережи
	int y;  //колонна сережи
	
	

	public  String calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		//int n = Integer.parseInt(br.readLine());
		
		
		int[] arr = new int[n];
		
		String[] vals = br.readLine().split(" ");
		
		n = Integer.parseInt(vals[0]);
		m = Integer.parseInt(vals[1]);
		k = Long.parseLong(vals[2]);
		x = Integer.parseInt(vals[3]);
		y = Integer.parseInt(vals[4]);
		
		long a1 = (long) Math.floor(k / ((n-((n > 1)?1:0)) * m));
		
		
		if  (k % ((n-((n > 1)?1:0)) * m) != 0)
			a1 ++;
		
		long a2 = (long) Math.ceil((double)a1 / 2f);
		
		long a3 = 0;  //a2 + (((int) (k % (m * n)) > (x * m + y)) ? 1 : 0);
		
		if (x == 0 || x ==n)
			a3 = a2;
		else
			a3 = a1;
		
		
		
		a3+= (((long) (k % ((n-((n > 1)?1:0)) * m)) > (x * (m - 1) + y)) ? 1 : 0);
		
		
		
		//long a = 1000000000000000000L;
		//long b = a / 50505050505051L; //101010101010101L;
		
		return  ""+a1 + " " + a2 + " "+a3;
	}
	
	public static void main(String[] args) throws Exception{


		Solution sol = new Solution();
		
		System.out.println(sol.calc());

	}

}
