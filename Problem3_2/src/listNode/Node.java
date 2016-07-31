
package listNode;

public class Node<T> {

	public Node next = null;
	public T data;
	
	public Node (T d) {
		data = d;
	}
	
	public void appendToTail(T d){
		Node end = new Node(d);
		Node n = this;
		while (n.next != null)
		{
			n = n.next;
		}
		n.next = end;
	}
	
	public Node deleteNode(Node head, T d)
	{
		Node n = head;
		
		if (n.data == d) {
			return head.next;
		}
		
		while (n.next != null)
		{
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;			
		}
		n = n.next;
	}
	return head;
	}
	
}
