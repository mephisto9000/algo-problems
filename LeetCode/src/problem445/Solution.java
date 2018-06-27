package problem445;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return processBack(process(l1), process(l2));
    }
    
    Stack<Integer> process(ListNode l) {
        Stack<Integer> s = new Stack();
        
        while(l != null) {            
            s.push(l.val);            
            l = l.next;
        }        
        return s;
    }
    
    ListNode processBack(Stack<Integer> s1, Stack<Integer> s2) {
        ListNode head = null;
        int rem = 0;
        while(s1.size() > 0 && s2.size() > 0) {
            int v = rem + s1.pop() + s2.pop();
            
            ListNode x = new ListNode(v % 10);
            rem = v / 10;
            
            if (head == null)
                head = x;
            else {
                x.next = head;
                head = x;
            }
        }
        
        while(s1.size() > 0) {
            int v = s1.pop() + rem;
            
            ListNode x = new ListNode(v % 10);
            rem = v / 10;
            
            if (head == null)
                head = x;
            else {
                x.next = head;
                head = x;
            }
            
        }
        
        
        while(s2.size() > 0) {
            int v = s2.pop() + rem;
            
            ListNode x = new ListNode(v % 10);
            rem = v / 10;
            
            if (head == null)
                head = x;
            else {
                x.next = head;
                head = x;
            }
            
        }
        
        if (rem > 0) {
            ListNode x = new ListNode(rem);                        
            x.next = head;
            head = x;           
        }
        
        return head;
    }
}