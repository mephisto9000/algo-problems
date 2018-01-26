package problem277;

/* The knows API is defined in the parent class Relation.
boolean knows(int a, int b); */
public class Solution extends Relation {

int n;

public int findCelebrity(int n) {
  this.n = n;
  for (int i = 0 ; i < n; i++)
  {
      if (testCelebrity(i))
          return i;
  }
  return -1;
  
}

boolean testCelebrity(int idx)
{
  int knowCount = 0;
  int doesntKnowCount = 0;
  for (int i = 0; i < n; i++)
  {
      if (i == idx)
          continue;
      
      if (!knows(i, idx))
          return false;
      
      if (knows(idx, i))
          return false;
  }
  
  return true;
  
  
}
}