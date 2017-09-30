package problem25;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    ListNode gnext;
    ListNode ghead = null;
    ListNode last = null;
    ListNode deep = null;
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (head == null)
            return null;
        
        if (!testDeep(head, k))
        	return head;
        	
        gnext = head;
        ListNode prevSegment = null;
        
        
        
        
        while(gnext!=null)
        {        	        	
        	ListNode segmentEnd = gnext;
        	        	        
            if (testDeep(gnext, k))
            {
            	segmentEnd = rev(gnext, k);
            }
            else
                break;
            
            segmentEnd.next = deep;
            
            if (prevSegment!=null)
            	prevSegment.next = last;
            
            prevSegment = segmentEnd;
            
            gnext = deep;                        
            
        }
        
        return ghead;
        
    }
    
    ListNode rev(ListNode node, int cnt)
    {
    	
        if (cnt == 0)
        {
             if (ghead == null)
                ghead = node;
            return node;
        }
        
        if (cnt == 1)
        {
            if (ghead == null)
                ghead = node;
            
            last = node;
            
            if (node != null)
            	deep = node.next;
            else
            	deep = null;
            
            return node;
        }
        
        rev(node.next, cnt-1).next = node;
                        
        return node;
    }
    
    boolean testDeep(ListNode node, int cnt)
    {
        if (cnt == 0)
            return true;
        
        if (node == null)
            return false;
        
        return testDeep(node.next, cnt -1);
    }
}