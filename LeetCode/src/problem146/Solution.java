package problem146;


class LRUCache {
    
    class CacheItem
    {
        int key;
        int value;
        int timeStamp;
        
        CacheItem prev;
        CacheItem next;
        
        public CacheItem(int key, int value, int count)
        {
            this.key = key;
            this.value = value;
            this.timeStamp = count;
        }
    }
    
    
    //Map<Integer, CacheItem> hs;
    LinkedHashMap<Integer, CacheItem> lhm; 
    
    
    int capacity;
    int occupied;
    int count;

    public LRUCache(int capacity) {
 
         this.capacity = capacity;
         count = 0;
         
        lhm = new LinkedHashMap<Integer, CacheItem>();
        occupied = 0;
    }
    
    public int get(int key) {
        
        count ++;
        
        if (lhm.containsKey(key))
        {
        	
        	CacheItem ci =lhm.remove(key);
        	
            ci.timeStamp  = count;
            
            lhm.put(key, ci);
            
            return ci.value;   
        }       

        return -1;
    }

    public void put(int key, int value) {
        count ++;
        
        if (lhm.containsKey(key))
        {
            CacheItem ci = (CacheItem) lhm.remove(key);            
             
            
            ci.timeStamp  = count;
            ci.value = value;
            
            lhm.put(key,  ci);
            
        }
        else
        {
            // removing head
            if (occupied >= capacity )
            {
            	
            	 //Set<Integer> keys = lhm.keySet();
            	 Integer fid = lhm.keySet().iterator().next();
            	 
            	 lhm.remove(fid);
            	  
            	
            	 
            }
            else
                occupied ++;

            CacheItem ci = new CacheItem(key, value, count);
            
            lhm.put(key, ci);            

        }
        
        
        
    }
     
}