package problem378;

class Solution {
    
    
    class HeapSort
    {
        int nums[];
        int len;
        
        public HeapSort(int line[])
        {
            this.nums = line;
            len = line.length;
            
            for (int i = len/2; i >= 0; i--)
                heapify(i);
            
            heapsort();
        }
        
        void heapify(int idx)
        {
            int maxi = idx;
            int maxv = nums[maxi];
            
            if ((idx * 2 + 1 < len) && nums[idx * 2 + 1] > maxv)
            {
                maxi = idx * 2 + 1;
                maxv = nums[maxi];
            }
            
            if ((idx * 2 + 2 < len) && nums[idx * 2 + 2] > maxv)
            {
                maxi = idx * 2 + 2;
                maxv = nums[maxi];
            }
            
            if (idx != maxi)
            {
                swap(maxi, idx);
                heapify(maxi);
            }
        }
        
        void heapsort()
        {
            for (int i = len -1; i >= 0; i--)
            {
                swap(0, i);
                len --;
                heapify(0);
            }
        }
        
        int getIth(int i)
        {
            return nums[i];
        }
        
        void swap(int idx1, int idx2)
        {
            int tmp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = tmp;
        }
        
        
    }
    
    
    public int kthSmallest(int[][] matrix, int k) {
        
         
        int h = matrix.length;
        int w = matrix[0].length;
        
        int line[] = new int[h * w];
        int z = 0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                line[z++] = matrix[i][j];
        
        HeapSort hs = new HeapSort(line);
        return hs.getIth(k-1);
        
         
    }
}