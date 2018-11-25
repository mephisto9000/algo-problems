import java.util.Stack;

public class Solution {
	
	public static void main(String[] args) {
		
		Stack<Integer> s1 = new Stack();
		Stack<Integer> s2 = new Stack();
		s1.push(500);
		s2.push(500);
		
		boolean eq = (s1.peek() == s2.peek());
		
		if (eq)
			System.out.println("ok");
		else
			System.out.println("not ok");
	}

}
