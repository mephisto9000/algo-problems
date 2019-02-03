package problem747;

class Solution {    
    class MyCmp implements Comparator<Integer> {
        int nums[];
        public MyCmp(int nums[]) {
            this.nums = nums;
        }
        
        @Override
        public int compare(Integer idx1, Integer idx2) {
            return nums[idx2] - nums[idx1];
        }
    }
    public int dominantIndex(int[] nums) {
        
        PriorityQueue<Integer> pq = new PriorityQueue(2, new MyCmp(nums));
        
        for (int i = 0; i < nums.length; i++) { 
            pq.add(i);
        }
        
        if (pq.size() == 0)
            return -1;
        if (pq.size() == 1)
            return pq.poll();
        
        int i1 = pq.poll();
        int i2 = pq.poll();
                
        if (nums[i1] >= nums[i2]*2)
            return i1;
        else
            return -1;                
    }
}