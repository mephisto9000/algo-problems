import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	List<Integer>  report;
	
	
	Comparator asc = new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			
			Integer i1 = (Integer) o1;
			Integer i2 = (Integer) o2;
			
			if (i1 < i2) 
				return -1;
			if (i1 > i2) 
				return 1;
			
			return 0;
		}
		
	};
	
	
	Comparator desc = new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			
			Integer i1 = (Integer) o1;
			Integer i2 = (Integer) o2;
			
			if (i1 > i2) 
				return -1;
			if (i1 < i2) 
				return 1;
			
			return 0;
		}
		
	};
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		
		String[] vals = br.readLine().split(" ");
		
		int n = Integer.parseInt(vals[0]);
		int m = Integer.parseInt(vals[1]);
		
		vals = br.readLine().split(" ");
		report = new ArrayList<Integer>();//[n];
		
		for (int i = 0; i < n; i++)
			//report[i] = Integer.parseInt(vals[i]);
			report.add(Integer.parseInt(vals[i]));
		
		for (int i = 0; i < m; i++)
		{
			vals = br.readLine().split(" ");
			int t = Integer.parseInt(vals[0]) ;
			int r = Integer.parseInt(vals[1]);
			
			
			
			//Arrays.sort(report, 0, r);
			
			Collections.sort( report, asc);
			//Arrays.sort(a, Collections.reverseOrder());
			//Arrays.sort(report, 0, r, Collections.reverseOrder());
			
			
			//ArrayUtils.
			
			if (t == 2)
			{
				
				int rover2 = r/2;
				//System.out.println("here");
				for (int j = r-1; j >= rover2; j--)
				{
					int tmp = report[j];
					report[j] = report[r - j - 1];
					report[r - j - 1] = tmp;
					
				}
			} 
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++)
		{
			sb.append(report[i]);
			sb.append(' ');
		}
		
		System.out.println(sb.toString().trim());
		
	}
	
	public static void main(String[] args) throws Exception {
		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
