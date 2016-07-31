import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		

		Scanner s = new Scanner(System.in);
		
		int v = s.nextInt();
		
		//System.out.println((long)Math.pow(2, v));
		int z = 1;
		for (int i = 0; i < v; i++)
		{
		z = z << 1;
		}
		
		System.out.println(z);

	}

}
