package problem923;

class Solution {
    public int threeSumMulti(int[] A, int target) {        
        Arrays.sort(A);
        int ans = 0;
        for (int i = 0; i < A.length -2; i++) {
            int j = i+1;
            int sum = target - A[i];
            
            int k = A.length-1;
            while(j < k) {
                if (A[j] + A[k] == sum) {
                    if (A[j]!=A[k]) {
                    int a = 1;
                    while(j+1 < k && A[j]==A[j+1]) {
                        a++;
                        j++;
                    }
                    int b = 1;
                    while(j < k-1 && A[k]==A[k-1]) {
                        k--;
                        b++;
                    }
                    
                    ans += (a*b) % (1000000000 + 7);
                    j++;
                    k--;
                    }
                    else {                
                    ans += (k-j+1) * (k-j) / 2;
                    ans %=  (1000000000 + 7);
                    break;
                
                    }
                }
                else if (A[j] + A[k] < sum)
                    j++;
                else
                    k--;
            }                       
        }
        return ans;
        
    }
}