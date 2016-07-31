import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SlayingDeerTest {

    protected SlayingDeer solution;

    @Before
    public void setUp() {
        solution = new SlayingDeer();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int A = 5;
        int B = 4;
        int C = 20;

        int expected = 20;
        int actual = solution.getTime(A, B, C);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int A = 5;
        int B = 4;
        int C = 47;

        int expected = 34;
        int actual = solution.getTime(A, B, C);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int A = 10;
        int B = 17;
        int C = 1;

        int expected = -1;
        int actual = solution.getTime(A, B, C);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int A = 133;
        int B = 198;
        int C = 7515;

        int expected = 7515;
        int actual = solution.getTime(A, B, C);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int A = 1;
        int B = 1000;
        int C = 15819;

        int expected = -1;
        int actual = solution.getTime(A, B, C);

        Assert.assertEquals(expected, actual);
    }

}
