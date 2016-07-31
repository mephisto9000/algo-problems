import static org.junit.Assert.*;
import codingInterviewLinkedList.Node;

import org.junit.Test;

import problem2_3.Problem3;
public class Problem3Test {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Node list = new Node(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		list.appendToTail(5);
		
		Node middle = list.next.next;
		
		
		Problem3 p3 = new Problem3();
		p3.process(middle);
		
		StringBuffer sb = new StringBuffer();
		while (list!= null)
		{
			//System.out.println(list.data);
			sb.append(list.data);
			list = list.next;
		}
		
		assertEquals(sb.toString(), "1245");
	}

}
