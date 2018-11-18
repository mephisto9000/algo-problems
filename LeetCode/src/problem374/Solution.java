package problem374;

/* The guess API is defined in the parent class GuessGame.
@param num, your guess
@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   int guess(int num); */

public class Solution extends GuessGame {
 public int guessNumber(int n) {
     
     int i = 1;
     int j = n;
     
     while(i <= j) {
         int m = (int) (((long)j+(long)i) /2L);
         
         int g = guess(m);
         if (g == 0)
             return m;
         if (g < 0)
             j = m-1;
         else
             i = m+1;
         
     }
     return -1;
     
 }
}