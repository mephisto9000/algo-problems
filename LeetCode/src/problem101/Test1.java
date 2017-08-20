package problem101;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class Test1 {

	@Test	
	@Ignore
	public void test1() {
		
		Solution sol = new Solution();
		
		//[1,2,2,3,4,4,3]
		
		TreeNode r = new TreeNode(1);
		TreeNode rl = new TreeNode(2);
		r.left = rl;
		
		TreeNode rr = new TreeNode(2);
		r.right = rr;
		
		TreeNode rll = new TreeNode(3);
		rl.left = rll;
		
		TreeNode rlr = new TreeNode(4);
		rl.right = rlr;
		
		TreeNode rrl = new TreeNode(4);
		rr.left = rrl;
		
		TreeNode rrr = new TreeNode(3);
		rr.right = rrr;
		
		
		assertTrue(sol.isSymmetric(r));
		
		 
	}
	
	
	@Test
	@Ignore
	public void test2() {
		
		Solution sol = new Solution();
				
		TreeNode r = new TreeNode(1);
		TreeNode rl = new TreeNode(2);
		r.left = rl;
		
		TreeNode rr = new TreeNode(2);
		r.right = rr;
		
		//TreeNode rll = new TreeNode(3);
		//rl.left = rll;
		
		TreeNode rlr = new TreeNode(3);
		rl.right = rlr;
		
		//TreeNode rrl = new TreeNode(4);
		//rr.left = rrl;
		
		TreeNode rrr = new TreeNode(3);
		rr.right = rrr;
		
		
		assertFalse(sol.isSymmetric(r));
		
		 
	}
	
	
	@Test
	public void test3() {
		
		Solution sol = new Solution();
				
		TreeNode r = new TreeNode(2);
		TreeNode rl = new TreeNode(3);
		r.left = rl;
		
		TreeNode rr = new TreeNode(3);
		r.right = rr;
		
		TreeNode rll = new TreeNode(4);
		rl.left = rll;
		
		TreeNode rlr = new TreeNode(5);
		rl.right = rlr;
		
		TreeNode rrl = new TreeNode(5);
		rr.left = rrl;
		
		TreeNode rrr = new TreeNode(4);
		rr.right = rrr;
		
		
		
		
		TreeNode rlrl = new TreeNode(8);
		rlr.left = rlrl;
		
		TreeNode rlrr = new TreeNode(9);
		rlr.right = rlrr;
		
		TreeNode rrll = new TreeNode(9);
		rrl.left = rrll;
		
		TreeNode rrlr = new TreeNode(8);
		rrl.right = rrlr;
		
		assertTrue(sol.isSymmetric(r));
		
		 
	}

}
