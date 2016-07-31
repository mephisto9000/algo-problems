public class TVAntenna {

	public double minRadius(int[] x, int[] y) {
		
		
		//return 0.0;
		int midX = 0;
		int midY = 0;
		
		
		double minRad = Double.MAX_VALUE;
		for (int i = -200; i < 201; i++ )
			for (int j = -200; j < 201; j++)
			{
				double tmpRad = 0;
				for (int z = 0; z < x.length; z++)
				{
					double rad = Math.sqrt(Math.pow(i - x[z],2) + Math.pow(j - y[z],2));
					
					if (rad > tmpRad)
						tmpRad = rad;
				}
				
				if (tmpRad < minRad)
					minRad = tmpRad;
			}
		
		return minRad;
		
		/*
		for (int i = 0 ; i < x.length; i++)
		{
			midX = midX + x[i] + 200;
			midY = midY +  y[i] + 200; 
			
		}
		
		midX /= x.length;
		midY /= x.length;
		
		double minRad = Double.MIN_VALUE;
		
		for (int i = 0; i < x.length; i++)
		{
			double tmp =  Math.sqrt( Math.pow((midX -  (x[i] + 200 )),2.0d) + Math.pow(midY - (y[i] + 200),2.0d)  );
			
			if (tmp > minRad)
				minRad = tmp;
		}
		
		return minRad;
		 */
	}
	
	

}
