package problem977;

class Solution {
    public int[] sortedSquares(int[] A) {
        
       for (int i = 0; i < A.length; i++)
            A[i] = A[i]*A[i];
                
        return qSort(A, 0, A.length-1);
    }
    
    int[] qSort(int a[], int l, int r) {
        
        int m = a[(l+r)/2];
        
        int i = l;
        int j = r;
        while(i <= j) {
            while(a[i] < m ) {                
                i++;
            }
            while(a[j] > m) {                
                j--;
            }
            
        if (i <= j) {
            swap(a,i,j);
            i++;
            j--;
        }
        }
        
        if (i  < r )
            qSort (a, i, r);
        if (j > l)
            qSort(a, l, j);
        return a;
    }
    
    void swap(int a[], int from, int to) {
        int x = a[from];
        a[from] = a[to];
        a[to] = x;
    }
}