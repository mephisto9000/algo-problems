
package stack;

import listNode.Node;

public class Stack
{
	Node top;

	public Object pop() {
		if (top != null)
		{
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}

	public void push (Object item)
	{
		Node t = new Node(item);
		t.next = top;
		top = t;
	}

	public Object peek()
	{
		return top.data;
	}
}