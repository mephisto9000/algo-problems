package problem7;

public class Solution {

	public static void main(String[] args) {


		Solution sol = new Solution();
		
		 int v = sol.reverse(-5332);
		 System.out.println(v);

	}
	
	 public int reverse(int x) {
		 
		 String s = String.valueOf(x);
		 
		 char[] arr = s.toCharArray();
		 
		 StringBuffer sb = new StringBuffer();
		 
		 
		 int endIdx = 0;
		 if (s.charAt(0) == '-')
		 {
			 sb.append('-');
			 endIdx = 1;
		 }
		 
		 int i = arr.length - 1;
		 while (i >= endIdx)
		 {
			 sb.append(arr[i]);
			 i--;
			 
			 try
			 {
				 Integer.parseInt(sb.toString());
			 }
			 catch (Exception e)
			 {
				 return 0;
			 }
		 }
		 
		 
		 
		 return Integer.parseInt(sb.toString());
	        
	 }

}
