
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public void calc() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] vals = br.readLine().split(" ");
		
		int n = Integer.parseInt(vals[0]);
		int m = Integer.parseInt(vals[1]);
		
		String initStr = br.readLine();
		
		
		
		
		
		List[] pointers = new List[30];
		
		for (int i = 0; i < 30; i++)
		{
			pointers[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i< initStr.length(); i++)
		{
			char c = initStr.charAt(i);
			
			List letter = pointers[c - 'a'];
			
			letter.add(new Integer(i));
		}
		
		for (int i = 0; i < m; i++)
		{
			String s = br.readLine();
			
			char c = s.charAt(0);
			char c1 = s.charAt(2);
			
			
			
			if (c!=c1)
			{
				/*
				for (int j = 0; j < sb.length(); j++)
				{
					if (sb.charAt(j) == c)
					{
						sb.deleteCharAt(j);
						sb.insert(j, c1);
					}
					else
					if(sb.charAt(j) == c1)
					{
						sb.deleteCharAt(j);
						sb.insert(j, c);
					}
					
				} */
				
				List cl = pointers[c-'a'];
				List cl1 =  pointers[c1 - 'a'];
				
				pointers[c1 - 'a'] = cl;
				pointers[c - 'a'] = cl1;
			}
		}
		
		char[] word = new char[initStr.length()];
		
		for (int i = 0; i < pointers.length; i++)
		{
			for (int j = 0; j < pointers[i].size(); j++)
				word[(int) pointers[i].get(j)] = (char) ( 'a'+i);
		}
		
		StringBuffer sb = new StringBuffer();
		//sb.append(initStr);
		for (int i = 0; i < word.length; i++)
		sb.append(word[i]);
		
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
