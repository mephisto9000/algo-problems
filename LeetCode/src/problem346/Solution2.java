package problem346;

class MovingAverage {

    /** Initialize your data structure here. */
    
    Deque<Integer> deque;
    long sum;
    int size;
    public MovingAverage(int size) {
        deque = new LinkedList<>();
        sum = 0;
        this.size = size;
    }
    
    public double next(int val) {
        if (deque.size() == size) {
            sum -= deque.pollFirst();
        }
        deque.add(val);
        sum += val;
        return ((double)sum )/ deque.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */