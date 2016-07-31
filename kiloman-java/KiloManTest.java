import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KiloManTest {

    protected KiloMan solution;

    @Before
    public void setUp() {
        solution = new KiloMan();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] pattern = new int[]{1, 3, 2, 3, 3, 1, 2, 2, 1};
        String jumps = "JJSSSJSSJ";

        int expected = 4;
        int actual = solution.hitsTaken(pattern, jumps);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] pattern = new int[]{1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7};
        String jumps = "SSSSSSSSSSSSSSJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ";

        int expected = 49;
        int actual = solution.hitsTaken(pattern, jumps);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] pattern = new int[]{1, 2, 2, 1};
        String jumps = "SJJS";

        int expected = 2;
        int actual = solution.hitsTaken(pattern, jumps);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] pattern = new int[]{1};
        String jumps = "J";

        int expected = 0;
        int actual = solution.hitsTaken(pattern, jumps);

        Assert.assertEquals(expected, actual);
    }

}
