import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountGameTest {

    protected CountGame solution;

    @Before
    public void setUp() {
        solution = new CountGame();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int maxAdd = 3;
        int goal = 20;
        int next = 10;

        int expected = 3;
        int actual = solution.howMany(maxAdd, goal, next);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int maxAdd = 5;
        int goal = 20;
        int next = 10;

        int expected = 5;
        int actual = solution.howMany(maxAdd, goal, next);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int maxAdd = 5;
        int goal = 20;
        int next = 9;

        int expected = -1;
        int actual = solution.howMany(maxAdd, goal, next);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int maxAdd = 4;
        int goal = 50;
        int next = 50;

        int expected = 1;
        int actual = solution.howMany(maxAdd, goal, next);

        Assert.assertEquals(expected, actual);
    }

}
