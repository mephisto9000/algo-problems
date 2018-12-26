package problem707;

class MyLinkedList {

    class Node {
        public Node next = null;;
        public Node prev = null;
        int val;
        public Node(int v) {
            val = v;
        }
    }
    
    Node head = null;
    Node tail = null;
    int cnt = 0;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        System.out.println(cnt);
        if (index < 0 || index >= cnt)
            return -1;
        Node tmp = null; 
        Node next = head;
        for (int i = 0; i <= index; i++) {
            tmp = next;
            next = next.next;
        }
        
        return tmp.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node tmp = new Node(val);
        tmp.next = head;
        if (head != null)
            head.prev = tmp;
        head = tmp;
        if (tail == null)
            tail = tmp;
        cnt++;
        
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node tmp = new Node(val);
        if (tail != null)
            tail.next = tmp;
        //if (head == null)
        //    tail.next = tmp;
        tmp.prev = tail;
        tail = tmp;
        if (head == null)
            head = tmp;
        cnt++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        
        
        
        if (index < 0 || index > cnt)
            return;
        Node tmp = null;
        Node next = head;
        
        
        for (int i = 0; i < index; i++) {
            tmp = next; //tmp.next;
            next = next.next;
        }
        Node nn = new Node(val);
        Node after = null;
        if (tmp!=null) {
            after = tmp.next;                
            tmp.next = nn;
        }
        nn.prev = tmp;
        nn.next = after;
        if (after!= null)
            after.prev = nn;
        
        if (index == 0) {
            head = nn;
        }
        
        if (index == cnt)
            tail = nn;
        cnt++;
        
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= cnt)
            return ;
        
        Node tmp = head;
        for (int i = 1; i <= index; i++)
            tmp = tmp.next;
        
        
        if (tmp.prev != null) 
            tmp.prev.next = tmp.next;
        else {
            head = head.next;
            head.prev = null;
        }
        
        if (tmp.next != null)
            tmp.next.prev = tmp.prev;
        else {
            tail = tail.prev;
            tail.next = null;
        }
        cnt--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */s