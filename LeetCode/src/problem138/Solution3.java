package problem138;

/*
//Definition for a Node.
class Node {
 public int val;
 public Node next;
 public Node random;

 public Node() {}

 public Node(int _val,Node _next,Node _random) {
     val = _val;
     next = _next;
     random = _random;
 }
};
*/
class Solution {
 public Node copyRandomList(Node head) {
     
     if (head == null)
         return head;
     
     Node newHead = new Node();
     
     Node ptr = head;
     
     //copy next
     while(ptr != null) {
                     
         Node next = ptr.next;
         Node x = new Node(ptr.val, null,null);
         ptr.next = x;
         x.next = next;
         ptr = next;
     }
     System.out.println(1);
     
     //copy rand
     ptr = head;
     while(ptr!=null) {
         Node rand = ptr.random;
         Node x = ptr.next;
         if (rand!=null)
             x.random = rand.next;
         
         ptr = x.next;
     }
     System.out.println(2);
     
     //fix sequence
     ptr = head.next;
     
     while(head!=null) {
         
         Node p2 = head.next;
         Node next = p2.next;
         
         ///if (next!=null) {
         head.next = next;
         if (next == null)
             p2.next = null;
         else
             p2.next = next.next;
         
         head = head.next;
     }
     
     return ptr;
     
     
 }
}