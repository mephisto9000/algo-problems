package problem138;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        
        RandomListNode newHead = null;        
        RandomListNode up = head;
                
        while(up!=null) { 
            
            RandomListNode tobenext = up.next;            
            RandomListNode tmp = new RandomListNode(up.label);            
            tmp.next = tobenext;
            up.next = tmp;            
            up = tobenext; 
        }        
        newHead = head.next;        
        up = head;
        while(up != null) {            
            if (up.random!=null)
                up.next.random = up.random.next;
            up = up.next.next;
        }
        
        up = head;
        while(up!= null) {
            RandomListNode tmp = up.next;
            
            up.next = tmp.next;
            up = up.next;
            
            if (up!=null) {
                tmp.next = up.next;
            }
        }
        
        return newHead;
        
        
    }
}