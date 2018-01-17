package problem281;

public class ZigzagIterator {
    
    Iterator<Integer> it1;
    Iterator<Integer> it2;
    
    int mode = 0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1 = v1.iterator();
        it2 = v2.iterator();
    }
    public int next() {        
        
        if (it1.hasNext() && it2.hasNext())
        {
            int v = 0;
            if (mode == 0)
            {
                mode = 1;
                v = (Integer) it1.next();
            }
            else
            {
                mode = 0;
                v = (Integer) it2.next();
            }
            return v;
        }
        else
        {
            if (it1.hasNext())
                return (Integer) it1.next();
            else
                return (Integer) it2.next();
        }
        
            
    }
    public boolean hasNext() {
        if (it1.hasNext() || it2.hasNext())
            return true;
        return false;
    }
}
/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
