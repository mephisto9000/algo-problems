package p2;
import java.util.*;
import java.io.*;

public class Main {
	
	String src = null;
	
	public String[] calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		int t = Integer.parseInt(br.readLine());
		
		String[] ans = new String[t];
		for (int i = 0; i< t; i++)
		{
			String v = br.readLine();
			
			char[] c = v.toCharArray();
			boolean[] marked = new boolean[c.length];
			
			Arrays.fill(marked, false);
			
			int j = 0;
			while(true)
			{
				
				
				
				if (j < 0)
					j = 0;
				
				if (j < (c.length-1))
				{
					if (c[j] <= c[j+1])
						j++;
					else
					{
						if (marked[j]==false)
						{
							c[j]--;
							marked[j]=true;
						}
						c[j+1] = '9';
						marked[j+1]=true;
						j--;
					}
				}
				
				if (j >= c.length-1)
					break;
				
			}
			
			
			boolean needZeroes = false;
			
			StringBuffer sb = new StringBuffer();
			
			
			
			
			for (int z = 0; z < c.length; z++ )
			{
				
				if (needZeroes == false && c[z] != '0')
					needZeroes = true;
				
				if (needZeroes)				
					sb.append(c[z]);
			}
			
			
			
			ans[i] = "Case #"+(i+1)+": "+sb.toString();
		}
		
		
		return ans;
	}

	public static void main(String[] args) throws Exception{

		
			Main m = new Main();
			
			
			String[] ans = m.calc();
			
			for (int i = 0; i < ans.length; i++)
				System.out.println(ans[i]);
		
		
		

	}

}
