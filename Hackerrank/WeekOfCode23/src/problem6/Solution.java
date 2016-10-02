package problem6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	String src;
	
	int n = 0;
	int[] lens;
	float[] angles;
	
	public String calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		n = Integer.parseInt(br.readLine());
		
		lens = new int[n];
		angles = new float[n];
		
		String[] vals = br.readLine().split(" ");
		
		int totalLen = 0;
		for (int i = 0; i < n; i++)
		{
			lens[i] = Integer.parseInt(vals[i]);
			totalLen += lens[i];
		}
		
		for (int i = 0; i < n; i++)
		{
			angles[i] = (float) ((float) (2*Math.PI * lens[i] )/ (float)totalLen);
		}
		
		float r =   (float) (lens[0] * Math.sin((Math.PI - angles[0])/2) / Math.sin(angles[0]));
		
		System.out.println( "r == "+r);
		
		System.out.println(angles[0]);
		
		System.out.println(((float) lens[0])/2.0f);
		
		float circleY = (float) lens[0] / 2;
		float circleX = (float) Math.sqrt(r*r - ((float) lens[0])/2.0f*((float) lens[0])/2.0f);
		
		System.out.println("cx == "+circleX);
		System.out.println("cy == "+circleY);
		
		StringBuffer sb = new StringBuffer();
		sb.append((float)0);
		sb.append('\n');
		sb.append((float)0);
		sb.append('\n');
		sb.append('\n');
		
		float angle = -angles[0] / 2;
		
		for (int i = 1; i < n; i++)
		{
			angle += angles[i];
			sb.append(circleX +  Math.cos(angle) * r );
			sb.append('\n');
			sb.append(circleY +  Math.sin(angle) * r );
			
			sb.append("\n\n");
			
		}
		
		return sb.toString();
		
		
		
		
		
		
		//return null;
		
	}

	public static void main(String[] args) throws Exception {

		Solution sol = new Solution();
		
		sol.src = "P6T0.txt";
		
		System.out.println(sol.calc());
		
		

	}

}
