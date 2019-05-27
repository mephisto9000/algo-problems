package problem1054;

class Solution {
    int nums[];
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        nums = barcodes;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for (int i =0; i < nums.length; i++) {
            int v = map.getOrDefault(nums[i], 0);
            map.put(nums[i], v+1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int a[], int b[] ) {
                if  (a[1] > b[1]) 
                    return -1 ;
                if (a[1] < b[1])
                    return 1;
                
                return a[0]-b[0];
            }
        });
        
        for (int key : map.keySet())   {
            
            int heapEntry[] = new int[] {key, map.get(key)};
            //System.out.println("key: " + name); 
            pq.add(heapEntry);
        }
        
        int ans[] = new int[nums.length];
        int i = 0;
        while(pq.size()> 0) {
            int[] common = pq.poll();
            
            ans[i++] = common[0];
            if (pq.size() > 0) {
                int[] uncommon = pq.poll();
                ans[i++] = uncommon[0];
                
                uncommon[1]--;
                if (uncommon[1] > 0)
                    pq.add(uncommon);
            }
            common[1]--;
            if (common[1] > 0)
                pq.add(common);
            
        }
        
        
        return ans;
    }
    
    void swap(int i, int j) {
        
        //if (j >= nums.length)
        //    return;
        int v = nums[j];
        nums[j] = nums[i];
        nums[i] = v;
    }
}