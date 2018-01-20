package problem251;

public class Vector2D implements Iterator<Integer> {
    List<List<Integer>> vec2d;
    int i = 0;
    int j = 0;
    
    List<Integer> cur;
    Iterator currIterator;
    
    public Vector2D(List<List<Integer>> vec2d) {
        
        if (vec2d == null || vec2d.size() == 0)
            return ;
        this.vec2d = vec2d;
        
        cur = vec2d.get(0);
        currIterator = cur.iterator();
    }
    @Override
    public Integer next() {
        
        if (vec2d == null)
            return null; 
        
        
        if (!hasNext())
            return null;
        else
        {
            return (Integer) currIterator.next();//cur.get(j++);
        }
    }
    @Override
    public boolean hasNext() {
        
        if (vec2d == null)
            return false; 
        
        
        if (currIterator.hasNext())
            return true;
        else
        {            
            if (i + 1 < vec2d.size())
              {
                 cur = vec2d.get(++i);
                 currIterator = cur.iterator();
                 return hasNext();
              }
              else
              {
                  return false;
              }
         }
        
    }
}
/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */