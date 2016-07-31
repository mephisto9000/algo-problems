package problem2_1;

import static org.junit.Assert.*;

import org.junit.Test;
import codingInterviewLinkedList.Node;
public class Problem1NodeTest1 {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Node n = new Node(1);
		n.appendToTail(3);
		n.appendToTail(1);
		n.appendToTail(3);
		
		Node n1 = new Node(1);
		n1.appendToTail(3);
		
		Problem1 p1 = new Problem1();
		
		n = p1.process(n);
		
		
		
		assertEquals(n, n1);
		
	}

}
