import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	
	public void calc() throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		
		StringBuffer a = new StringBuffer();
		
		a.append(br.readLine());
		
		 s = br.readLine();
		//a.append(br.readLine().in);
		 a.append(s.charAt(1));
		 a.append(s.charAt(0));
		
		StringBuffer b = new StringBuffer();
		
		b.append(br.readLine());
		
		s = br.readLine();
		
		b.append(s.charAt(1));
		b.append(s.charAt(0));
		s = a.toString().replace("X", "");
		if ((s+s).contains(b.toString().replace("X","")))
				System.out.println("YES");
		else
			System.out.println("NO");
		
		
		
		
		
	}
	

	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
