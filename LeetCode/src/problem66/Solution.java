package problem66;

public class Solution {
	
	public static void main(String[] args)
	{
		Solution sol = new Solution();
		
		int[] arr= {7,4,5,8,9,8,7,6,5,4,3,2,1,0};
		
		int a[] = sol.plusOne(arr);
		
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);
	}
    public int[] plusOne(int[] digits) {
        
        long v = 0;
        
        StringBuffer sb = new StringBuffer();
        
        
        boolean increase = true;
        if (digits.length > 0)
        {
            long z = 1;
            for (int i = digits.length -1; i >=0; i--)
            {
                int x = digits[i];
                
                if (increase)
                {
                	if (x < 9)
                	{
                		x++;
                		increase = false;
                	}
                	else
                		x = 0;
                }
                
                sb.insert(0, Integer.toString(x).charAt(0)); 
                
            }
            
            if (increase)
            	sb.insert(0, '1');
        }
        
       
        
        //String s = String.valueOf(v);
        
        int ans[] = new int[sb.toString().length()];
        
        for (int i = 0; i < ans.length; i++)
            ans[i] = sb.toString().charAt(i) - '0';
        
        return ans;
        
    }
}