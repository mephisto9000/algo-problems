package problem848;

class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        
        char[] arr = S.toCharArray();
        
        long x = 0;
        for (int i = 0; i < shifts.length; i++)
            x+= shifts[i];
        for (int i = 0; i < shifts.length; i++) {
            arr[i] = (char)(((arr[i]-'a' + x) % 26) +'a');
            x-= shifts[i];
        }
        
        return new String(arr);
        
    }
}