package problem347;

class Solution {
    
    class IntComparator implements Comparator<Map.Entry<Integer,Integer>> {
            public int compare(Map.Entry<Integer,Integer> a, Map.Entry<Integer,Integer> b)
            {
                return a.getValue() - b.getValue();
            }
        }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++)
        {
            if (!map.containsKey(nums[i]))
            {
                map.put(nums[i], 1);                
            }
            else
            {
                int v = map.get(nums[i]);
                map.put(nums[i], ++v);
            }
            
        }
        
        int setMin = Integer.MAX_VALUE;
                                
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<Map.Entry<Integer,Integer>>(k, new  IntComparator());
            
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) 
        {   
            if (pq.size() >= k)
            {
                if (pq.peek().getValue() > entry.getValue())
                    continue;
                pq.poll();
            }
            pq.add(entry);            
        }
        
        
        List<Integer> ans = new LinkedList();
        while(!pq.isEmpty())
        {
            Map.Entry<Integer,Integer> e = pq.poll();                        
            ans.add(e.getKey());
        }        
        return ans;                        
    }
}
