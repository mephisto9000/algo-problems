package problem324;

class Solution {
    
    int partition(int[] nums, int l, int r ) {
        
        int pivot = nums[r];
        
        int i = l;
        for (int j = l; j <= r-1; j++) {
            if (nums[j] <= pivot) {
               swap(nums, i, j);                                
                i++;
            }
        }
        
        swap(nums, i, r);
        
        return i;
    }
    
    int quickselect(int nums[], int l, int r, int k ) {
        
         if (k > 0 && k <= r - l + 1) {
        int idx = partition(nums, l, r );
             
        //System.out.println(idx + " --- "+k);
        
        if (idx - l == k -1 )
            return idx-1;
        
        //if (idx -l> k-1)
        if (idx - l > k - 1) 
            return quickselect(nums, l, idx-1, k);
        else
            return quickselect(nums, idx, r, k+l - idx - 1);
         }
        return Integer.MAX_VALUE;
    }
    
    void printArray(int nums[]) {
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i]+" ");
        System.out.println();
    }
    
    public void wiggleSort(int[] nums) {
        
        
         int p = quickselect(nums, 0, nums.length-1, nums.length/2 );
        
       // i  nt cpy[] = nums.clone();
        //printArray(cpy);
        //System.out.println(p);
        
       
       
        
      
        //if (cpy[j] == cpy[i])
        //    j++;
        int m = nums.length;
        int median = nums[(nums.length-1)/2]; 
        int i = 1;   // position for the larger values: start with first odd index
        int j = ((m - 1) & 1) > 0 ? m - 2 : m - 1;  // position for the smaller values: start with last even index
        for (int l = 0; l < m; ++l) {
            if (nums[l] > median) {  // fill the large element
                if (l <= i && (l & 1 )> 0) continue;       // skip the elements which are  already checked: 1, 3, 5, ..., i
                swap(nums,l--, i);
                i += 2;
            } else if (nums[l] < median) {  // fill the smaller element
                if (l >= j && (l & 1) == 0) continue;     // skip the elements whcih are checked: j, j + 2, ..., lastEvenIndex
                swap(nums,l--, j);
                j -= 2;
            }
       }
    }  
        
   
    
    void swap(int nums[], int i, int j) {
        int v = nums[i];
        nums[i] = nums[j];
        nums[j] = v;
    }
}