package problem346;

class MovingAverage {
    
    int size;
    Deque<Integer> d;
    int total;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        d = new LinkedList();
        total = 0;
    }
    
    public double next(int val) {
        
        d.addLast(val);
        
        total += val;
        if (d.size() > size)
            total -= d.pollFirst();
        
        return ((double) total ) / d.size();
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */