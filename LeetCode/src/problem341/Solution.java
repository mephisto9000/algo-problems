package problem341;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
        
    static Stack<Iterator<NestedInteger>> s;
    NestedInteger tmpNi;
    
    static {
        s = new Stack();
    }
        
    public NestedIterator(List<NestedInteger> nestedList) {        
         Iterator<NestedInteger> it = nestedList.iterator();
        tmpNi = null;
        s.push(it);
    }

    @Override
    public Integer next() {
        
        if (tmpNi!= null )
        {
            if (tmpNi.isInteger())
            {
                int v = tmpNi.getInteger();
                tmpNi = null;
                return v;
            }
            else
            {
                s.push(tmpNi.getList().iterator());
                tmpNi = null;
            }
            
            
        }
         
        while(s.size() > 0)
        {
           Iterator<NestedInteger> it = s.peek();
            
            
            if (!it.hasNext())
            {
                s.pop();
            }
            else
            {  
                NestedInteger ni = it.next();
                if (ni.isInteger())
                    return ni.getInteger();
                else
                {
                    Iterator<NestedInteger> nit = ni.getList().iterator();
                                        
                    s.push(nit);
                }
            }
        }
        return null;
            
    }

    @Override
    public boolean hasNext() {
        while(s.size() > 0)
        {
           Iterator<NestedInteger> it= s.peek();
            
            if (it.hasNext())
            {
                tmpNi = it.next();
                if (tmpNi.isInteger())
                {
                    return true;
                }
                if (tmpNi.getList().size() > 0)    
                {
                    Iterator<NestedInteger> nit = tmpNi.getList().iterator();                   
                    
                    s.push(nit);
                }                

            }
            else
                s.pop();
        }
        
        return false;
        
        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */