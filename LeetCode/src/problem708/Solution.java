package problem708;

/*
//Definition for a Node.
class Node {
 public int val;
 public Node next;

 public Node() {}

 public Node(int _val,Node _next) {
     val = _val;
     next = _next;
 }
};
*/
class Solution {
 public Node insert(Node head, int insertVal) {
   
   Node x = new Node();
   x.val = insertVal;
   
   if (head == null) {
     x.next = x;
     return x;
   }
   
   Node tmp = null;
   
   tmp = findOrderNode(head, insertVal);
   if (tmp == null)
     tmp = findCliff(head);
   
   if (tmp == null)
     tmp = head;
                 
   x.next = tmp.next;
   tmp.next = x;
   return head;
   
 }

Node findOrderNode(Node head, int val) {
  Node tmp = null;
   while(tmp != head) {
     if (tmp == null)
       tmp = head;
     if ((tmp.val <= val && tmp.next.val > val))            
         return tmp;
     tmp = tmp.next;  
   }
    return null; 
   }

Node findCliff(Node head) {
 Node tmp = null;
   while(tmp != head) {
     if (tmp == null)
       tmp = head;
     if (tmp.val > tmp.next.val)
         return tmp;
     tmp = tmp.next;  
   }
    return null; 
   }
  
}