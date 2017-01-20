package B;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	public class Node{
		
				
		int val = 15;
		
		char c = '!';
		
		boolean given = false;
	}
	
	
	Node[] colors;
	int n;

	public  String calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s =  br.readLine();
		
		n = s.length();
		
		char[] arr = new char[s.length()];
		
		//String[] vals = br.readLine().split(" ");
		
		int max = 0;
		
		colors = new Node[s.length()];
		
		for (int i = 0; i < s.length(); i++)
		{
			arr[i] =   s.charAt(i);
			
			//if (max < arr[i])
			//	max = arr[i];
			colors[i] = new Node();
			
			//if (arr[i]!=)
			colors[i].c = arr[i];
			
			if (arr[i]!='!')
				colors[i].given = true;
			
		}
		
		
		//System.out.println("here");
		
		int ans = 0;
		
		boolean done = false;
		while(done == false)
		{
			done = true;
			
			//System.out.println("processing");
			
		for (int i = 0; i < s.length(); i++)
		{
			//ans += (max - arr[i]);
			if (!check(i))
				done = false;
		
		}
		
		}
		
		int r = 0;
		int g = 0;
		int b = 0;
		int y = 0;
		
		//System.out.println("here2");
		
		for (int i = 0; i < s.length(); i++)
		{
			Node node = colors[i];
			
			if (node.given)
				continue;
			
			//System.out.println(node.val);
			
			switch (node.val)
			{
			case 1 :
				r++;
				break;
			case 2:
				g++;
				break;
			case 4 :
				b++;
				break;
			case 8:
				y++;
				break;
				
			}
		}
		
		return ""+r+' '+b+' '+y+' '+g;
	}
	
	boolean check(int idx)
	{
		//if ()
		
		Node node = colors[idx];
		
		if (node.c == '!')
			return true;
		
		int tidx = idx - 3;
		
		int v = 0;
		int vidx = 0;
		switch (node.c)
		{
		case 'R' :
			v = 1;
			vidx = 0;
			break;
		case 'G':
			v = 2;
			vidx = 1;
			break;
		case 'B' :			
			v = 4;
			vidx = 2;
			break;
		case 'Y':
			v = 8;
			vidx = 3;
			break;
			
		}
		
		node.val = v;
		
		boolean done = true;
		
		while (tidx <= idx + 3)
		{
			if (tidx < 0 || tidx >=n || tidx == idx)
			{
				tidx++;
				continue;
			}
			
			Node tnode  = colors[tidx];
			
			int x = tnode.val;
			
			if (((tnode.val >> vidx) & 1) == 1)// && tnode.val != v)
			{
				tnode.val = tnode.val ^ v;
				done = false;
			}
			
			
			if (tnode.val == 1)
				tnode.c = 'R';
			
			if (tnode.val == 2)
				tnode.c = 'G';
			
			if (tnode.val == 4)
				tnode.c = 'B';
			
			if (tnode.val == 8)
				tnode.c = 'Y';
			
			
			tidx ++;
		}
		
		return done;
		
	}
	
	public static void main(String[] args) throws Exception{


		Solution sol = new Solution();
		
		System.out.println(sol.calc());

	}

}
