package problem155;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinStack {
	
	
	public class Element{
		public Element nextMin;
		public Element prevMin;
		public int val;
		
	}
	
	
	List<Element> stack;
	Element min;
			
	public MinStack()
	{
		
		stack = new LinkedList<Element>();		
		min = null;
		
	}
	
	public void push(int x) {
		
		Element e = new Element();
		e.val = x;
        stack.add(0, e);
        
        if (min==null)
        	min = e;
        else
        {
        	if (min.val > x )
        	{
        		e.nextMin = min;
        		min = e;
        	}
        }
        
        
    }

    public void pop() {
    	
    	if (!stack.isEmpty())
    	{
    		if (min == stack.get(0))
    		{
    			min = min.nextMin;
    		}
    		
    		stack.remove(0);
    	}
        
    }

    public int top() {
    	if (stack.isEmpty())
    		return -1;
    	
    	Element e = stack.get(0);
    	return e.val;
        
    }

    public int getMin() {
        return min.val;
    }
}
