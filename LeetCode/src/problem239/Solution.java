package problem239;

class Solution {
    
    Deque<Integer> maxQueue;
    int[] nums;
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        this.nums = nums;
        if (nums == null || nums.length == 0)
            return new int[0];
        maxQueue = new LinkedList();
        
        for (int i = 0; i < k; i++) {
            enqueue(nums[i]);
        };
        
        int ans[] = new int[nums.length - k +1];
        for (int i =k; i < nums.length; i++) {
            ans[i-k] = dequeue(i - k);
            enqueue(nums[i]);
        }
        
        ans[nums.length-k]= dequeue(nums.length - k);
        
        return ans;
            
        
        
        
    }
    
    void enqueue(int v) {
        while(maxQueue.size() > 0 ) {
            if (maxQueue.peekLast()  < v)
                maxQueue.pollLast();
            else
                break;
        }
        maxQueue.add(v);        
    }
    
    int dequeue(int idx) {  
 
        if (nums[idx] < maxQueue.peekFirst())            
            return maxQueue.peekFirst();
        else
            return maxQueue.pollFirst();
 
    }
}