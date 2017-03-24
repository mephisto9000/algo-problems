import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public String src = null;
	public int calc() throws Exception
	{
		Scanner s = null;
		
		if (src!=null)
			s = new Scanner(src);
		else
			s = new Scanner(System.in);
		
		int n = s.nextInt();
		int k = s.nextInt();
		
		int tluck = 0;
		
		//Queue<Integer> imps = new PriorityQueue<Integer>();
		List<Integer> imps = new LinkedList<Integer>();
		
		for (int i = 0; i < n; i++)
		{
			int luck = s.nextInt();
			int imp = s.nextInt();
			
			tluck += luck;
			
			if (imp == 1)
				imps.add(luck);
		}
		
		int subt = 0;
		Collections.sort(imps);
		
		int isize = imps.size();
		for (int i = 0; i < (isize - k) ; i++)
		{
			
			int v = imps.remove(0); //.poll();
			
			//if (i >  isize - k)
			subt += v;
		}
		
		return  tluck - 2*subt  ;
		
	}

	public static void main(String[] args) throws Exception{


		Solution sol = new Solution();
		System.out.println(sol.calc());

	}

}
