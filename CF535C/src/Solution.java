import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    
    
    public void calc() throws Exception
    {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input3.txt"));
        
        String vals[] = br.readLine().split(" ");
        
        long a= Integer.parseInt(vals[0]);
        long b = Integer.parseInt(vals[1]);
        long n = Integer.parseInt(vals[2]);
        
        //long d = new long i
        for (int i = 0; i < n; i++)
        {
            vals = br.readLine().split(" ");
            
            long l = Integer.parseInt(vals[0]);
            long t = Integer.parseInt(vals[1]);
            long  m = Integer.parseInt(vals[2]);

            long sum = (long) t * (long)m;

            long aggr = 0;
            int z_mid = 500000;
            int z_max = 1000000;
            long z_min = l;
            long init_l = l;
            
            //System.out.println("sum == "+sum);
            
            long s1 = a+ (l-1)*b;
            
            
            //z = (sum + l ) / 2 + l;
            
            if (s1 <= t)
            {
            while(true)
            {
                //long sn = a+ (l+z-1)*b;
            	
            	//System.out.println("z_max == "+z_max+ " z_min == "+z_min + " z_mid == "+z_mid);
            	
            	aggr = calcSum((long) a, (long) b, (long) init_l,  (long)z_mid);
            	
            	 //s1 = a+ (z_mid-1)*b;
            
            	if (aggr <= sum)
            	{
            		z_min = z_mid;
            		z_mid = (int)(z_min + (z_max - z_min) / 2.0f);
            		
            		
            	}
            	else
            	{
            		z_max = z_mid;
            		z_mid = (int)(z_min + (z_max - z_min) / 2.0f);
            		
            	}
            	
            	if (z_max - z_min <= 1)
            		break;
            	 
                    
                // a+ (l+z-1)*b;
                // System.out.println("aggr == "+aggr);

                // System.out.println(l-1+z);
            }
            
            }

            if (s1 <= t)
                System.out.println(z_mid);
            else
                System.out.println("-1");
            
        }
        
    }
    
    public long calcSum(long a, long b, long l, long r)
    {
    	long result =   (a * (r - l + 1) + b * ( r*(r-1)/2 -  l*(l-1)/2 ));
    	return result;
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        sol.calc();

    }

}