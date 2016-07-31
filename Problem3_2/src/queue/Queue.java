package queue;

import listNode.Node;

public class Queue {
	Node first, last;

	void enqueue (Object item) {
		if (first == null) {
			last = new Node(item);
			first = last;
		}
		else
		{
			last.next = new Node(item);
			last = last.next;
		}
	}

	Object dequeue() {
		if (first != null) {
			Object item = first.data;
			first = first.next;
			if (first == null)
				last = null;

			return item;
		}
		return null;
	}

}