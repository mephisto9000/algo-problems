package problem752;

class Solution {
    
    Set<String> deadSet = null;
    
    class Move
    {
        int moves;
        String combo;
        
        public Move(int moves, String combo)
        {
            this.moves = moves;
            this.combo = combo;
        }
    }
    public int openLock(String[] deadends, String target) {
        deadSet = new HashSet(Arrays.asList(deadends));
        
        String combo = "0000";
        
        
        if (deadSet.contains(combo))
                return -1;
        
        Queue<Move> q = new LinkedList();
        q.add(new Move(0, combo));
            
        //int count = 0;
        //q.add(combo);
        while(!q.isEmpty())
        {
            Move move = q.poll();
            combo = move.combo;
            int count = move.moves;  
            
            
            
            for (int i = 0; i < 4; i++)
            {
                String x = turn(combo, i, 1);
                
                if (x.equals(target))
                    return count + 1;
                
                if (!deadSet.contains(x))
                {
                    deadSet.add(x);
                    q.add(new Move(count +1, x));
                }
   
            }
            
            for (int i = 0; i < 4; i++)
            {
                String x = turn(combo, i, -1);
                
                if (x.equals(target))
                    return count + 1;
                
                if (!deadSet.contains(x))
                {
                    deadSet.add(x);
                    q.add(new Move(count +1, x));
                }
   
            }
            
            count ++;
        }
                
        return -1;
        
    }
    
    String turn(String s, int wheel, int dir)
    {
        StringBuilder sb = new StringBuilder(s);
        
        int v = sb.charAt(wheel) - '0';
        if (dir > 0)
            v ++;
        else
            v --;
        if (v == 10)
            v = 0;
        else
        if (v == -1)
            v = 9;
        
        sb.deleteCharAt(wheel);
        sb.insert(wheel, v);
        
        return sb.toString();
    }
}