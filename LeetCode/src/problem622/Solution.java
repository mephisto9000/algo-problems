package problem622;

class MyCircularQueue {

    
    public class Node {
        int v;
        public Node next;
        public Node prev;
        public Node(int v) {
            this.v = v;
        }
        
    }
    
    int size;
    int maxSize;
    Node head;
    Node tail;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        head = null;
        tail = null;
        size = 0;
        maxSize = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        
        if (size == maxSize)
            return false;
        size++;
        Node tmp = new Node(value);
        if (tail == null) {
            tail = tmp;
            head = tmp;
        }
        else {
            tmp.prev = tail;
            tail.next = tmp;
            tail = tmp;
        }
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (size == 0)
            return false;
        if (tail == head) {
            tail = null;
            head = null;
        }
        else {
            head = head.next;
        }
        size--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (size==0)
            return -1;
        return head.v;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (size==0)
            return -1;
        return tail.v;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (size==0);
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (size==maxSize);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */