package problem204;

public class Solution {
    public int countPrimes(int n) {
        
        if (n <=2 )
    		return 0;
        
 
        
        
        boolean primes[] = new boolean[n+1];
        
        Arrays.fill(primes, true);
        
        
        
        primes[0] = false;
        primes[1] = false;
        
        
       
        for (long i = 2; i <= n; ++i) // n;
        {
        	if (primes[(int)i])
       
        	if (i * i <= n && i*i >=0)
            for (long j = i*i; j <= n; j+=i )
            {
            	
            	if (j < n)
            	{
            	 
                primes[(int)j] = false;
            	}
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < n; i++)
        	if (primes[i])
        		cnt++;
        
        return cnt;	       
    }
}