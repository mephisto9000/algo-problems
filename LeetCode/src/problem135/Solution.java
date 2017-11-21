package problem135;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    
    public class Child implements Comparable
    {
        public int rating;
        public int candies;
        
        public Child left = null;
        public Child right = null;
        
        public Child(int rating)
        {
            this.rating = rating;
            
        }
        
        @Override
        public int compareTo(Object o)
        {
            Child other = (Child) o;
            
            if (rating <  other.rating)
                return -1;
            if (rating >  other.rating)
                return 1;
            return 0;
        }
    }
    public int candy(int[] ratings) {
        
        if (ratings == null || ratings.length == 0)
            return 0;
        
        int n = ratings.length;
                    
        List<Child> kids = new LinkedList();
        Child lastChild = null;
        for (int i = 0; i <n; i++)
        {
            Child c = new Child(ratings[i]);
            kids.add(c);
            
            if (lastChild != null)
            {
                lastChild.right = c;
                c.left = lastChild;
            }
            
            lastChild = c;
        }
        
        Collections.sort(kids);
        
        int ans = 0;
        
        Iterator it = kids.iterator();
        while(it.hasNext())
        {
            Child c = (Child) it.next();
             
            int minCandies = 1;
            
            boolean assigned = false;
            
            if (c.left != null && c.left.rating < c.rating)
            {
                minCandies = Math.max(minCandies, c.left.candies); 
                assigned = true;
            }
            
            if (c.right != null && c.right.rating < c.rating)
            {
                minCandies = Math.max(minCandies, c.right.candies); 
                assigned = true;
            }
            
            if (assigned)
            	minCandies ++;
            
                         
            c.candies = minCandies;
            ans += minCandies;
                        
        }
        
        return ans;
        
    }
}