package problem3_1;

//import MyNode.*;



public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Object[] mem = new Object[10];
		P1Node.initNodes(mem); 
		
		P1Stack s = new P1Stack();
		
		s.push(new Integer(1));
		s.push(new Integer(2));
		s.push(new Integer(3));
		s.push(new Integer(4));
		
		
		P1Stack s2 = new P1Stack();
		
		s2.push(6);
		s2.push(7);
		s2.push(8);
		s2.push(9);
		
		
		P1Stack s3 = new P1Stack();
		
		s3.push(10);
		s3.push(11);
		s3.push(12);
		s3.push(13);
		
		System.out.println("stack1");
		while (s.peek()!=null)
		{
			
			
		Integer i =  (Integer) s.pop();
		System.out.println(i);
		
		
		}
		
		System.out.println("stack2");
		
		while (s2.peek()!=null)
		{
			
			
		Integer i =  (Integer) s2.pop();
		System.out.println(i);
		
		
		}
		
		System.out.println("stack3");
		
		while (s3.peek()!=null)
		{
			
			
		Integer i =  (Integer) s3.pop();
		System.out.println(i);
		
		
		}
		
		
		s.push(new Integer(1));
		s.push(new Integer(2));
		s.push(new Integer(3));
		s.push(new Integer(4));
		s.push(new Integer(5));
		s.push(new Integer(6));
		s.push(new Integer(7));
		s.push(new Integer(8));
		s.push(new Integer(9));
		s.push(new Integer(10));
		
		System.out.println("stack1");
		while (s.peek()!=null)
		{
			
			
		Integer i =  (Integer) s.pop();
		System.out.println(i);
		
		
		}
		
	}

}
