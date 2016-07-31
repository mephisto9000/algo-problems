
package problem3_1;

//import listNode.Node;

public class P1Stack
{
	P1Node top;

	Object pop() {
		if (top != null)
		{
			Object item = top.data;
			P1Node oldTop = top;
			top = top.next;
			
			oldTop.delete();
			
			return item;
		}
		return null;
	}

	void push (Object item)
	{
		P1Node t = P1Node.get();
		
		if (t == null)
		{
			//System.out.println("null!");
			return;
		}
		
		t.data = item;
		//Node t = new Node(item);
		t.next = top;
		top = t;
	}

	Object peek()
	{
		if (top==null)
			return null;
		return top.data;
	}
}