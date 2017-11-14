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
        RandomListNode otail = head;
        RandomListNode nhead = new RandomListNode(head.label);
        RandomListNode ntail = nhead;
        
        otail = otail.next;
        
        Map<RandomListNode, RandomListNode>  m = new HashMap();
        
        m.put(head, nhead);
        
        while(otail!=null)
        {
            RandomListNode tmp = new RandomListNode(otail.label);
            ntail.next = tmp;
            ntail = tmp;
            
            m.put(otail, ntail);
            
            otail = otail.next;
        }
        
        //nhead.random = m.get(ohead.random);
        otail = head;
        ntail = nhead;
        
        while(otail != null)
        {
            ntail.random = m.get(otail.random);
            
            otail = otail.next;
            ntail = ntail.next;
        }
        
        
        return nhead;
    }
}