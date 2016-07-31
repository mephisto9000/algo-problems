import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RSABreakerTest {

    protected RSABreaker solution;

    @Before
    public void setUp() {
        solution = new RSABreaker();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int e = 3;
        int n = 10;
        int b = 3;

        int expected = 7;
        int actual = solution.decrypt(e, n, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int e = 17;
        int n = 33;
        int b = 4;

        int expected = 31;
        int actual = solution.decrypt(e, n, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int e = 1;
        int n = 42;
        int b = 17;

        int expected = 17;
        int actual = solution.decrypt(e, n, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int e = 5;
        int n = 997;
        int b = 7;

        int expected = 523;
        int actual = solution.decrypt(e, n, b);

        Assert.assertEquals(expected, actual);
    }

}
