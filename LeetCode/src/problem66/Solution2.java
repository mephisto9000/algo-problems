package problem66;

public class Solution {
    public int[] plusOne(int[] digits) {
        
       // test if 999
        
       if (test9(digits)) {
           int ans[] = new int[digits.length+1];
           ans[0] = 1;
           return ans;
       } 
       
       for (int i = digits.length-1; i >= 0; i--) {
           if (digits[i]==9)
               digits[i]=0;
           else {
               digits[i]++;
               break;
           }
               
       }
       
       return digits;
       
   }
   
   boolean test9(int digits[]) {
       for (int i = 0; i < digits.length; i++)
           if (digits[i]!=9)
               return false;
       return true;
   }
}