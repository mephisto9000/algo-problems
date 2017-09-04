package problem23;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode l = null;
        ListNode tail = null;
        
        
        ListNode max = new ListNode(Integer.MAX_VALUE);
        
        ListNode min = max;
        int minI = -1;
        
        Comparator<ListNode> comp = new Comparator<ListNode>()
        {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				
				if (o1.val < o2.val)
					return -1;
				
				if (o1.val > o2.val)
					return 1;
				return 0;
			}
        	
        };
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(100, comp);
        
        for (int i = 0; i < lists.length; i++)    
        {
        	if (lists[i]!=null)
        		pq.add(lists[i]);
        }
        
        while(true)
        {
            //min = max;
            min = ( ListNode) pq.poll();
            if (min == null)
            	break;
            
            
            
            if (l == null)
            {
                l = new ListNode(min.val);
                tail = l;
            }
            else
            {
                tail.next = new ListNode(min.val);
                tail = tail.next;
            }
            
            min = min.next;
            if (min != null)
            	pq.add(min);
            //lists[minI] = lists[minI].next;            
        }
        
        return l;
        
    }
}