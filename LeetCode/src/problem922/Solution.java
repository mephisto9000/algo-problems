package problem922;

class Solution {            
    int evenIdx = -1;
    int oddIdx = -1;
    
    public int[] sortArrayByParityII(int[] A) {         
        for (int i = 0; i < A.length-1; i++) {
            if( (i & 1) == 0 ) {
                if ((A[i] & 1) != 0)
                    swap(A, i, findEven(A, i));
            } else {
                if ((A[i] & 1) == 0)
                    swap(A, i, findOdd(A, i));
            }
        }        
        return A;        
    }
    int findEven(int[] A, int baseIdx) {
        for (int i = baseIdx+1; i < A.length; i++) {
            if ((A[i] & 1) == 0) {
                evenIdx = i;
                break;
            }                
        }
        return evenIdx;
    }
    
    int findOdd(int[] A, int baseIdx) {
        for (int i = baseIdx + 1; i < A.length; i++) {
            if ((A[i] & 1) != 0) {
                oddIdx = i;
                break;
            }
        }
        return oddIdx;
    }
    
    void swap(int[] A, int i, int j) {
        int v = A[i];
        A[i] = A[j];
        A[j] = v;
    }
}