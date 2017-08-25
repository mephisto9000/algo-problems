package problem60;

public class Solution {

	 public static void main(String[] args) {
		 
		 Solution sol = new Solution();
		 
		 System.out.println(sol.getPermutation(5,0));
		 System.out.println(sol.getPermutation(5,1));
		 System.out.println(sol.getPermutation(5,2));
		 System.out.println(sol.getPermutation(5,3));
		 System.out.println(sol.getPermutation(5,4));
		 
		 
		 
		 

	 }

	 int[] arr;
	 int n;

	 public String getPermutation(int n, int k) {
	 
		 arr = new int[n];
		 this.n = n;
		 
		 for (int i = 0; i < n; i++)
		 {
			 arr[i] = i+1; 
		 }
		 
		 if (n == 1)
			 return "1";
		 		 		 
		 int z = 0;
		 
		 while(z < k)
		 {
			 for (int i = n-2; i >=0; i-- )
			 {
				 if (arr[i] < arr[i+1])
				 {
					 int max_j = -1;
					 
					 for (int j = i+1; j < n; j++)
					 {
						 if (arr[j]>arr[i])
							 max_j = j;
					 }
					 
					 swap(i,max_j);
					 
					 //if (max_j)
					 //printArray();
					 rotate(i+1, n-1);
					 
					 //System.out.println(z);
					 //printArray();
					 z++;
					 break;
					 
				 }
			 }
			 
			 
		 }
		 
		 StringBuffer sb = new StringBuffer();
		 for (int i = 0; i < n; i++)
			 sb.append(arr[i]);
			 
		 
		 return sb.toString();
	 }
	 
	 void printArray()
	 {
		 StringBuffer sb = new StringBuffer();
		 for (int i = 0; i < n; i++)
			 sb.append(arr[i]);
		 
		 System.out.println(sb.toString());
	 }
	 
	 void rotate(int i, int j)
	 {
		 int []tmp = new int[j-i+1];
 		 
		 int t = 0;
		 for (int z = i; z <= j; z++)
		 {
			 tmp[t] = arr[z];
			 t++;
		 }
		 
		 
		 for (int z = i; z <= j; z++)
		 {
			 t--;
			 arr[z] = tmp[t];		 
					 
		 }
	 }
	 
	 void swap(int i, int j)
	 {
		 int v = arr[i];
		 arr[i] = arr[j];
		 arr[j] = v;
	 }

}
