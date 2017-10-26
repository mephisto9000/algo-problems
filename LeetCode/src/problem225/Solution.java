package problem225;

class MyStack {

    /** Initialize your data structure here. */
    
    
    Queue<Integer> q1 = null;
    int t = 0;
    public MyStack() {
        q1 = new LinkedList<Integer>();
         
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        t = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        
        Queue q2 = new LinkedList<Integer>();  
        int s =  q1.size();
        for (int i = 0; i < s-1; i++)
        {
            t = q1.remove();
            q2.add(t);
            
        }
        
        int ans = q1.remove();
        
        q1 = q2;
        
        return ans;
        
    }
    
    /** Get the top element. */
    public int top() {
        return t;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (q1.size() == 0)
            return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */