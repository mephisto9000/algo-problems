import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("A-large.in.txt"));
		//BufferedReader br = new BufferedReader(new FileReader("ttt.ttt.txt"));
		
		PrintWriter out = new PrintWriter("out");
		
		
		int numTestCases = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < numTestCases; i++)
		{
			String str = br.readLine();
			
			
			
			int maxShiness = 0;					
			int j = 0;
			// reading maxShiness... 
			while(true)
			{
				if (str.charAt(j)==' ')
				{
					j++;
					break;
				}
				if (j == 0)
					maxShiness = Character.getNumericValue(str.charAt(j));
				else
				{
					maxShiness *= 10;
					maxShiness += Character.getNumericValue(str.charAt(j));
				}
				j++;
			}
			
			//for ()
			
			int [] people = new int[maxShiness+1];
			
			for (int z = 0; z < maxShiness; z++)
				people[z] = 0;
			
			//reading people!
			int z = 0;
			while(true)
			{
				if ( j >= str.length() || str.charAt(j)==' ' )
					break;
				
				people[z] = Character.getNumericValue(str.charAt(j));
				
				j++;
				z++;
				
			}
			
			
					
			int peopleNeedToStand = 0;
			int peopleStanding = 0;
			
			for ( z = 0; z < people.length; z++)
			{
				//people
				
				if (people[z]>0 && peopleStanding < z)
				{
					peopleNeedToStand += (z - peopleStanding);
					peopleStanding += (z - peopleStanding);
				}
					
				peopleStanding += people[z];
			}
			
			//System.out.println("Case #"+(i+1)+": "+peopleNeedToStand);
			out.println("Case #"+(i+1)+": "+peopleNeedToStand);
			
			
			
			
		}
		out.close();

	}

}
