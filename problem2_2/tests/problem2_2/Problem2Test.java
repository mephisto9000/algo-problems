package problem2_2;

import static org.junit.Assert.*;

import org.junit.Test;
import codingInterviewLinkedList.Node;
public class Problem2Test {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		Node n = new Node(1);
		n.appendToTail(2);
		n.appendToTail(3);
		
		
		Node n1 = new Node(2);
		
		Problem2 p = new Problem2();
		
		Node n3 = p.kToLast(n, 1);
		
		assertEquals(n1.data, n3.data);
	}

}
