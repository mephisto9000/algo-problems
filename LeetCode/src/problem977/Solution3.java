package problem977;

class Solution {
    public int[] sortedSquares(int[] A) {
        
       for (int i = 0; i < A.length; i++)
            A[i] = A[i]*A[i];
        return hSort(A);
    }
    
    int hlen = 0;
    int[] hSort(int A[]) {
        hlen = A.length;        
        for (int i = hlen / 2; i >= 0; i--) {
            heapify(A, i);            
        }
        
        for (int i = hlen-1; i >= 0; i--) {
            swap(A, 0, i);
            hlen--;
            heapify(A, 0);
        }
        return A;
        
    }
    
    void heapify(int a[], int idx) {
        
        int midx = idx;        
        if (idx*2+1 < hlen && a[idx*2+1] > a[idx]) 
            midx = idx*2+1;            
        
        if (idx*2+2 < hlen && a[idx*2+2] > a[midx])
            midx = idx*2+2;
        
        if (idx != midx) {
            swap(a, idx, midx);
            heapify(a, midx);
        }
        
    }
            
    void swap(int a[], int from, int to) {
        int x = a[from];
        a[from] = a[to];
        a[to] = x;
    }
}