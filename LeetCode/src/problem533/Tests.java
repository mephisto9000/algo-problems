package problem533;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.Assert;
//...

public class Tests {
		

	@Test
	public void test() {
		Solution sol = new Solution();
		
		char[][] picture = {{'W','B','W','B','B','W'},
							{'W','B','W','B','B','W'},
							{'W','B','W','B','B','W'},
							{'B','W','B','W','W','B'}};
		
	
	
				
		assertEquals(0, sol.findBlackPixel(picture, 2));
		//assertEquals(0, 
		//		sol.findBlackPixel(picture, 2);//);
	}

}
