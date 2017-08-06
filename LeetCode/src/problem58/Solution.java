package problem58;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int lengthOfLastWord(String s) {
	        
	        String[] vals = s.split(" ");
	        
	        int n = vals.length;
	        
	        if (n > 0)
	            return vals[n-1].length();
	            else
	            return 0;
	        
	}
	

}
