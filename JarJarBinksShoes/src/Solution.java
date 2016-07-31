import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	public class Shoe
	{
		public String brand;
		public int size;
		public String color;
		public int type;
		
		public String print()
		{
			return new String(brand+"_"+size+"_"+color+"_"+type);
		}
		
		public Shoe(String brand, int size, String color, int type)
		{
			super();
			this.brand = brand;
			this.size = size;
			this.color = color;
			this.type = type;
		}
		
		@Override
		public boolean equals(Object o) 
		{
		    if (o instanceof Shoe) 
		    {
		      Shoe c = (Shoe) o;
		      //if ( this.FIELD.equals(c.FIELD) ) //whatever here
		      int score = 0;
		      if (this.brand.equals(c.brand))
		    	  score++;
		      if (this.size == c.size)
		    	  score++;
		      if (this.color.equals(c.color))
		    	  score++;
		      if (this.type == c.type)
		    	  score++;
		      
		      if (score == 4)
		         return true;
		    }
		    return false;
		}
		
		//public haskKey
	}

	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> shoes = new HashMap<String, Integer>();
		
		int total = 0;
		
		for (int i = 0; i < n; i++)
		{
			String[] vals = br.readLine().split(" ");
			String brand = vals[0];
			int size = Integer.parseInt(vals[1]);
			String color = vals[2];
			int type = (vals[3].equals("L") ? 0 : 1);
			
			Shoe shoe = new Shoe(brand, size, color, type);
			//shoe.print();
			Shoe antagonist = new Shoe(brand, size, color, 1 - type);
			//antagonist.print();
			
			Integer v = shoes.get(antagonist.print());
			
			if (v != null && v > 0)
			{
				//v = shoes.get(antagonist);
				v--;
				total++;
				shoes.put(antagonist.print(), v);
			}
			else
			{
				v = shoes.get(shoe.print());
				if (v == null)
					v = 0;
				v++;
				shoes.put(shoe.print(), v);
			}
				
			
			
		}
		
		System.out.println(total);
	}
	
	public static void main(String[] args) throws Exception {

		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
