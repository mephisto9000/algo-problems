package problem3_1;

public class P1Node {
	
	private static Object[] storage;
	private static P1Node head;
	
	int index;		
	public Object data;
	public P1Node next;
	 
	
	
	public static void initNodes(Object[] arrayOfObjects)
	{
		storage = arrayOfObjects;
		//head = new MyNode();
		
		P1Node n = null;
		
		for (int i = 0; i < storage.length; i++)
		{
			P1Node n1 = new P1Node(i);
			storage[i] = n1;
			
			if (n == null)
			{
				head = n1;
				n = n1;
			}
			else
			{
				n.next = n1;
				n = n1;
			}
			
		}
		
		
	}
	
	private P1Node(int index)
	{
		super();
		this.index = index;
		next = null;
	}
	
	public static P1Node get() {
		
		if (head == null)
			return null;
		
		P1Node result = head;
		head = head.next;
		
		result.next = null;
		
	    
		
		return result;
		
	}
	
	public void delete() {
		this.next = head;
		this.data = null;
		head = this;
	}
	
	

}
