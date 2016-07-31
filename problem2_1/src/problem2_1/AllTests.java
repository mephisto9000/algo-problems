package problem2_1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Problem1Test.class, 
				Problem1Test2.class, 
				Problem1NoBufferTest1.class,
				Problem1NoBufferTest2.class
				})
public class AllTests {

}
