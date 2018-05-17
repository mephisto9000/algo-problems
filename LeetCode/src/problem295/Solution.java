package problem295;

class MedianFinder {

    /** initialize your data structure here. */
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    int step = 0;
    
    public MedianFinder() {
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(Collections.reverseOrder()); 
    }
    
    public void addNum(int num) {
       minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if (maxHeap.size() > minHeap.size() )
            minHeap.add(maxHeap.poll());
 
       
    }
    
    public double findMedian() {
        
        if (minHeap.size() == maxHeap.size())
            return (minHeap.peek() + maxHeap.peek()) / 2.0d;
        return minHeap.peek();
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */