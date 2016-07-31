import java.util.Arrays;

public class IBEvaluator {

	public int[] getSummary(int[] predictedGrades, int[] actualGrades) {
		
		
		int[] p = predictedGrades;
		int[] a = actualGrades;
		
		int[] r = new int[7];
		
		Arrays.fill(r,0);
		int total = 0;
		
		for (int i = 0; i < p.length; i++)
		{
			int z = Math.abs(p[i] - a[i]);
			r[z] ++;
			total ++;
		}
		
		for (int i = 0; i < 7; i++)
		{
			r[i] = (int) Math.floor(r[i] * 100 / total);
			//r[i] = total;
		}
		
		return r;
	}

}
