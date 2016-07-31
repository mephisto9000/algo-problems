import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Solution {
	
	
	public class City
	{
		public int id; 
		public List<City> neighbour;
		
	}
	
	List<City> cities;
	
	
	public void calc() throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++)
		{
			int n = Integer.parseInt(br.readLine());
			
			
		}
		
		
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		sol.calc();

	}

}
