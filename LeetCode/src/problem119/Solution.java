package problem119;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        
   
        
        List prev = new LinkedList();
        //List ans = new LinkedList();
        for (int i = 0; i <= rowIndex; i++)
        {
            
            Iterator it = prev.iterator();
            List curr = new LinkedList();
            
            int pv = 0;

            while(it.hasNext())
            {
                int v = (Integer) it.next();
                int tmp = v;
                v+= pv;
                pv = tmp;
                
                curr.add(v);
            }
            
            curr.add(1);
            
            //ans.add(curr);
            
            prev = curr;           
        }
        
        return prev;
        
    }
}