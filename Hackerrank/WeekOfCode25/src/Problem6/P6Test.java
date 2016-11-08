package Problem6;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class P6Test {

	@Test
	public void test() throws Exception{
		
		Solution sol = new Solution();
		
		sol.src = "P6T1.txt";
		Queue<Integer> l = (Queue<Integer>) sol.calc();
		
		int ans[] = new int[l.size()];
		
		int size = l.size();
		Iterator it = l.iterator();
		//for (int i = 0; i < size; i++ )
		int j = 0;
		while(it.hasNext())
		{
			ans[j] = (Integer) it.next();//l.poll();
			
			System.out.println(ans[j]);
			j++;
		}
		
		assertArrayEquals(new int[]{3, 3, 3, 3, 3, 2, 3, 2, 0, 0, 3, 2, 3, 2}, ans);
		
	}

}
