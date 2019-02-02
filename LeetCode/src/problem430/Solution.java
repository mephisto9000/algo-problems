package problem430;

/*
//Definition for a Node.
class Node {
 public int val;
 public Node prev;
 public Node next;
 public Node child;

 public Node() {}

 public Node(int _val,Node _prev,Node _next,Node _child) {
     val = _val;
     prev = _prev;
     next = _next;
     child = _child;
 }
};
*/
class Solution {
 
 Node dummy;
 Node last;
 public Node flatten(Node head) {
     if (head == null)
         return null;
     dummy = new Node();
     last = dummy;
     rec(head);
     dummy = dummy.next;
     dummy.prev = null;
     return dummy;            
 }
 
 public void rec(Node head) {
     if (head == null)
         return;
     
     Node t = new Node();
     t.val = head.val;
     last.next = t;
     t.prev = last;
     last = t;
     rec(head.child);
     rec(head.next);
 }
}