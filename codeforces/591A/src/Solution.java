import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public void calc() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
				
		int l = Integer.parseInt(br.readLine());
		
		
		int p = Integer.parseInt(br.readLine());
		int q = Integer.parseInt(br.readLine());
		
		//System.out.println((double) l)
		
		float  aspect = (float)l / (float)(p + q);
		
	    System.out.println(p * aspect);
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
