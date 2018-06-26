package problem232;

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s;
    /** Initialize your data structure here. */
    public MyQueue() {        
        s = new Stack();
        s1 = new Stack();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        s.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        if (s1.size() == 0)
            while (s.size() > 0) {
                s1.push(s.pop());
            }
        
        return s1.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        if (s1.size() == 0)
            while (s.size() > 0) {
                s1.push(s.pop());
            }
        return s1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (s.size() == 0 && s1.size() == 0)
            return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */