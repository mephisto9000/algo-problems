package stack;

import listNode.MinNode;

public class MinStack extends Stack {
	
	//@Override
	//public void push(
	
	public void push(MinNode node)
	{
		
		if (node == null)
			return;
		if (top == null)
		{
			node.min = (Integer) node.data;
			top = node;
			return;
		}
		
		
		node.next = top;
		
		if ((Integer) top.data < ((Integer) node.data))
			node.min = ((MinNode) top).min;
		else
			node.min = (Integer) node.data;
		
		top = node;
	}
	
	public MinNode minPop()
	{
		MinNode r = (MinNode) top;
		
		top = top.next;
		return r;
	}

}
