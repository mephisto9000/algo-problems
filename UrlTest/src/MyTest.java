
public class MyTest {
	
	
	public void calc()
	{
		
		String path = "http://www.google.cim/smth/yetanothersmth/blah.jpg";
		
		int last = path.lastIndexOf('/');
		
		System.out.println(path.substring(0,  last+1) + "HD/" + path.substring(last+1, path.length()));
	}

	public static void main(String[] args) {
		

		MyTest mt = new MyTest();
		
		mt.calc();

	}

}
