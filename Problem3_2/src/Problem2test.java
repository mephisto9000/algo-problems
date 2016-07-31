import static org.junit.Assert.*;

import org.junit.Test;

import listNode.MinNode;
import stack.MinStack;
import stack.Stack;

public class Problem2test {

	@Test
	public void test() {
		//fail("Not yet implemented");
		MinStack s = new MinStack();
		MinNode m1 = new MinNode(1);
		
		MinNode m2 = new MinNode(2);
		MinNode m3 = new MinNode(3);
		
		s.push(m2);
		s.push(m1);
		s.push(m3);
		
		MinNode r1 = (MinNode) s.minPop();
		MinNode r2 = (MinNode) s.minPop();
		MinNode r3 = (MinNode) s.minPop();
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(r1.min);
		sb.append(r2.min);
		sb.append(r3.min);
		
		
		assertEquals(sb.toString(), "112");
		
		
		
	}

}
