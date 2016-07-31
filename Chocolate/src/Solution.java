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

	 

	public static void main(String[] args) throws IOException 
	{
		BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader sb = new BufferedReader(new FileReader(new File("case1.txt")));

		String s = sb.readLine();

		StringTokenizer st = new StringTokenizer(s);
		
		int t = Integer.parseInt(st.nextToken());
		
		
		

		

		for (int i = 0; i < t ; i++)
		{
			s = sb.readLine();
			
			long k = Long.parseLong(s);
			
			double kmid = ((double) k / 2);
			
			//System.out.println("kmid == "+kmid);
			long fl = (long) Math.floor(kmid); //System.out.println("fl == "+fl);
			long to = (long) Math.ceil(kmid); //System.out.println("to == "+to);
			
			
			System.out.println(fl*to);
			
		}


		


	}
}