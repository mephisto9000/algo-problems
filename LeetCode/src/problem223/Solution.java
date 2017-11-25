package problem223;


public class Solution {
		
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		
		int x1,y1, x2,y2;
		
		y1 = Integer.max(B, F);		
		y2 = Integer.min(D, H);
	        
		x1 = Integer.max(A, E);
		x2 = Integer.min(C,G);
            
        
		
		int a1 = (C-A) * (D - B);
		int a2 = (G-E) * (H-F);
		int diff = ((x2-x1) * (y2-y1)); 
        
        if (E > A && E > C || G < A && G < C)
            diff *= 0;
        
        if (F > B && F > D || H < B && H < D)
            diff *= 0;
		
       
        
		return (a1 + a2 - diff);
	}
	

}