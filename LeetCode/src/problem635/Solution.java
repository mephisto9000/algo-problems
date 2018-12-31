package problem635;

class LogSystem {

    TreeMap<String, Integer> map = new TreeMap();
   
    public LogSystem() {
        
    }
    
    int convertIdx( String gra) {
        int lim = 0; 
        if (gra.equals("Year"))
            lim = 4;
        else
        if (gra.equals("Month"))
            lim = 7;
        else
        if (gra.equals("Day"))
            lim = 10;
        else
        if (gra.equals("Hour"))
            lim = 13;
        else
        if (gra.equals("Minute"))
            lim = 16;
        else
        if (gra.equals("Second"))
            lim = 19;
       return lim;
    }
                
    public void put(int id, String timestamp) {
        map.put(timestamp, id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {

        
        String min = "2000:01:01:00:00:00";
        String max = "2017:12:31:23:59:59";
        
        int idx = convertIdx(gra);
        String key1 = s.substring(0, idx) + min.substring(idx);
        String key2 = e.substring(0, idx) + max.substring(idx);
                
        Set<String> ks = map.tailMap(key1).keySet();        
        Iterator<String> it = ks.iterator();
        List<Integer> ans = new LinkedList();
        while(it.hasNext()) {
            String k = it.next();            
            if (k.compareTo(key2) > 0)
                continue;
            
            ans.add(map.get(k));
        }
        
        return ans;

    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */