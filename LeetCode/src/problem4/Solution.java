package problem4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue(100);
        PriorityQueue<Integer> maxHeap = new PriorityQueue(100, Collections.reverseOrder());
        
        for (int i = 0; i < nums1.length; i++) {
            minHeap.add(nums1[i]);
            maxHeap.add(minHeap.poll());
            
            if (maxHeap.size() > minHeap.size())
                minHeap.add(maxHeap.poll());
        }
        
         for (int i = 0; i < nums2.length; i++) {
            minHeap.add(nums2[i]);
            maxHeap.add(minHeap.poll());
            
            if (maxHeap.size() > minHeap.size())
                minHeap.add(maxHeap.poll());
        }
        
        if (minHeap.size() > maxHeap.size()) 
            return minHeap.peek();
        else
            return ((minHeap.peek() + maxHeap.peek()) / 2.0d);
            
        
    }
}