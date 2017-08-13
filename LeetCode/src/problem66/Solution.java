package problem66;

public class Solution {
	
	public static void main(String[] args)
	{
		Solution sol = new Solution();
		
		int[] arr= {9,8,7,6,5,4,3,2,1,0};
		
		int a[] = sol.plusOne(arr);
		
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);
	}
    public int[] plusOne(int[] digits) {
        
        long v = 0;
        
        if (digits.length > 0)
        {
            long z = 1;
            for (int i = digits.length -1; i >=0; i--)
            {
                long x = digits[i] * z;
                
                v += x;
                z *= 10;
                
            }
        }
        
        v++;
        
        String s = String.valueOf(v);
        
        int ans[] = new int[s.length()];
        
        for (int i = 0; i < ans.length; i++)
            ans[i] = s.charAt(i) - '0';
        
        return ans;
        
    }
}