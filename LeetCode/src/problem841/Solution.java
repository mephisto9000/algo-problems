package problem841;

class Solution {
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {        
        Set<Integer> keySet = new HashSet();
        Queue<Integer> q = new LinkedList();
        q.add(0);
        keySet.add(0);
        while(!q.isEmpty()) {
            int k = q.poll();
            
            List<Integer> l = rooms.get(k);
            Iterator<Integer> kit = l.iterator();
            while(kit.hasNext()) {
                int tk = kit.next();
                if (!keySet.contains(tk)) {
                    keySet.add(tk);
                    if (keySet.size() == rooms.size())
                        return true;
                    q.add(tk);
                }
            }
        }
        
        return (keySet.size() == rooms.size());        
    }
}