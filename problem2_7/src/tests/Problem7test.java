package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import problem2_7.Problem7;
import codingInterviewLinkedList.Node;

public class Problem7test {

	@Test
	public void test() {
				
		Node n = new Node(1);
		n.appendToTail(2);
		n.appendToTail(3);
		
		n.appendToTail(3);
		n.appendToTail(2);
		n.appendToTail(1);
		
		Problem7 p = new Problem7();
		boolean b = p.process(n);
		
		assertTrue("blah!", b);
	}
	
	@Test
	public void test1() {
		
		
		Node n = new Node(1);
		n.appendToTail(2);
		n.appendToTail(3);
		
		n.appendToTail(4);
		n.appendToTail(2);
		n.appendToTail(1);
		
		Problem7 p = new Problem7();
		boolean b = p.process(n);
		
		assertFalse("blah!", b);
	}
	
	@Test
	public void test3() {
		
		
		Node n = new Node(1);
		
		
		Problem7 p = new Problem7();
		boolean b = p.process(n);
		
		assertTrue("blah!", b);
	}
	
	@Test
	public void test4() {
		
		
		Node n = null;
		
		
		Problem7 p = new Problem7();
		boolean b = p.process(n);
		
		assertFalse("blah!", b);
	}



}
