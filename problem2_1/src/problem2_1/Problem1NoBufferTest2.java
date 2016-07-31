package problem2_1;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Problem1NoBufferTest2 {

	@Test
	public void test() {
Problem1 p1 = new Problem1();
		
		List<Integer> list = new LinkedList<Integer>();
		
		list.add(1);
		list.add(5);
		list.add(0);
		list.add(1);
		list.add(0);
		list.add(10);
		
		List<Integer> resultList = new LinkedList<Integer>();
		resultList.add(1);
		resultList.add(5);
		resultList.add(0);
		resultList.add(10);
		
		
		list = p1.processWithNoBuffer(list);
		assertEquals(list, resultList);
	}

}
