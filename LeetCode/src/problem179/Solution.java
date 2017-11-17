package problem179;


public class Solution {
   
	public class IntComparator implements Comparator<String>
   {
   
   public int compare(String x, String y)
   {

       String a= x + y;
   	String b = y + x;
   	
   	long v1 = Long.parseLong(a);
   	long v2 = Long.parseLong(b);
   	
   	if (v1 > v2)
   		return -1;
   	if (v2 > v1)
   		return 1;
   	return 0;
       
        
   }
   }
   
   public String largestNumber(int[] nums) {       
       
       if (nums == null || nums.length == 0)
           return null;
       
       Comparator<String> comp = new IntComparator();
       PriorityQueue pq = new PriorityQueue(nums.length, comp);
       
       for (int i = 0; i < nums.length; i++)
       {
           pq.add(String.valueOf(nums[i]));
       }
       
       StringBuffer sb = new StringBuffer();
       
       while(!pq.isEmpty())
       {
           sb.append(pq.poll());
       }
       
        if (sb.toString().charAt(0) == '0')
           return "0";
       else            
           return   sb.toString();
       
   }
}