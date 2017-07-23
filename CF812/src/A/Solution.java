package A;

import java.util.Scanner;

public class Solution {

	public int calc() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int[][] mtx = new int [4][4];
		
		for (int i = 0; i < 4; i++)
		{
			int l = sc.nextInt();
			int s = sc.nextInt();
			int r = sc.nextInt();
			int p = sc.nextInt();
			
			mtx[i][0] = l;
			mtx[i][1] = s;
			mtx[i][2] = r;
			mtx[i][3] = p;
		}
		
		
		int ans = 0;
		for (int i = 0; i < 4; i++)
		{
			int il = i-1;
			if (il < 0)
				il = 3;
			
			int ir = i + 1;
			if (ir >= 4)
				ir = 0;
			
			int iff = i + 2;
			if (iff >= 4)
				iff -= 4;
				
			
			if (mtx[i][0] == 1 && (mtx[i][3] == 1 || mtx[il][3] ==1 ))
			{
				ans = 1;
				break;
			}
			
			if (mtx[i][1] == 1 && (mtx[i][3]==1 || mtx[iff][3] == 1))
			{
				
				//System.out.println(i + " " +mtx[i][1]  );
				//System.out.println((mtx[iff][3] == 1) + " "+iff);
				ans = 1;
				break;
			}
			
			if (mtx[i][2]==1 && (mtx[i][3]==1 || mtx[ir][3] == 1))
			{
				ans = 1;
				break;
			}
		}
		
		
		return ans;
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		
		if (sol.calc() == 1)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
