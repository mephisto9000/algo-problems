import static org.junit.Assert.*;

import org.junit.Test;

import problem2_6.Problem6;
import codingInterviewLinkedList.Node;


public class Problem6Test {

	@Test
	public void test1() {
		//fail("Not yet implemented");
		
		Node a = new Node(1);
		Node b = new Node(2);
		a.next = b;
		
		Node c = new Node(3);
		b.next = c;
		
		Node d = new Node(4);
		c.next = d;
		
		Node e = new Node(5);
		d.next = e;		
		e.next = c;

		Problem6 p = new Problem6();

		Node x = p.process(a);
		
		assertEquals(c, x);
		
	}
	
	@Test
	public void test2()
	{
		Node a = new Node(1);
		a.appendToTail(2);
		a.appendToTail(3);
		
		Problem6 p = new Problem6();
		Node x = p.process(a);
		
		assertNull(x);
	}

}
