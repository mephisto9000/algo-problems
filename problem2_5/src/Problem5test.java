import static org.junit.Assert.*;

import org.junit.Test;

import problem2_5.Problem5;
import codingInterviewLinkedList.Node;


public class Problem5test {

	
	
	@Test
	public void test1() {
		//fail("Not yet implemented");
		
		Node n1 = new Node(7);
		n1.appendToTail(1);
		n1.appendToTail(6);
		
		Node n2 = new Node(5);
		n2.appendToTail(9);
		n2.appendToTail(2);
		
		Problem5 p = new Problem5();
		
		int v = p.process1(n1, n2);
		
		assertEquals(912, v);
	}
	
	@Test
	public void test3() {
		//fail("Not yet implemented");
		
		Node n1 = new Node(1);
		
		
		Node n2 = new Node(5);
		n2.appendToTail(9);
		n2.appendToTail(2);
		
		Problem5 p = new Problem5();
		
		int v = p.process1(n1, n2);
		
		assertEquals(296, v);
	}
	
	@Test
	public void test2() {
		Node n1 = new Node(6);
		n1.appendToTail(1);
		n1.appendToTail(7);
		
		Node n2 = new Node(2);
		n2.appendToTail(9);
		n2.appendToTail(5);
		
		Problem5 p = new Problem5();
		int v = p.process2(n1, n2);
		
		assertEquals(912, v);
	}
	
	@Test
	public void test4() {		
		Node n1 = new Node(1);
		
		
		Node n2 = new Node(2);
		n2.appendToTail(9);
		n2.appendToTail(5);
		
		Problem5 p = new Problem5();
		int v = p.process2(n1, n2);
		
		assertEquals(296, v);
	}

}
