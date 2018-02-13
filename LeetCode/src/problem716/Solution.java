package problem716;

class MaxStack {
    class Node  
    {
        public boolean popped;
        public int val;
        public int id;
        public Node(int val, int id)
        {
            this.val = val;
            popped = false;
            this.id = id;
        }                
    }
    
    class NodeComparator implements Comparator<Node>
    {
        public int compare(Node n1, Node n2)
        {
            if (n1.val != n2.val)
                return  -n1.val + n2.val;
            else
                return -n1.id + n2.id;                
        }
    }
    
    Stack<Node> normalStack;
    PriorityQueue<Node> maxQueue;
    int cnt;        
    public void check()
    {
        while(!normalStack.isEmpty() && normalStack.peek().popped)
        {
            normalStack.pop();
        }
        
        while(!maxQueue.isEmpty() && maxQueue.peek().popped)
        {
            maxQueue.poll();
        }
    }
    
    public MaxStack() {
        normalStack = new Stack();
        maxQueue = new PriorityQueue(new NodeComparator());
        cnt = 0;        
    }
    
    public void push(int val) {        
        Node x = new Node(val, cnt++);        
        normalStack.push(x);
        maxQueue.add(x);
    }
    
    public int pop() {              
        Node x;
        while(true)
        {
        x = normalStack.pop();        
        if (!x.popped )
        {
            x.popped = true;                 
            check();        
            return x.val;
        }
        }
        
    }
    
    public int top() {
        
        while(true)
        {        
            Node x = normalStack.peek(); 
            if (!x.popped)
                return x.val;
            
            normalStack.pop();             
        }        
    }
    
    public int peekMax() {        
        Node x = maxQueue.peek();
        return x.val;                 
    }
    
    public int popMax() {              
        while(true) {
        Node x = maxQueue.poll();            
        if (!x.popped)
        {
            x.popped = true;
            check();            
            return x.val;           
        }
        }
    }
}
/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */