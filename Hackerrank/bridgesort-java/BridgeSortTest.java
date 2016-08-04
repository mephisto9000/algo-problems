import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BridgeSortTest {

    protected BridgeSort solution;

    @Before
    public void setUp() {
        solution = new BridgeSort();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String hand = "HAH2H3C4D5ST";

        String expected = "C4D5H2H3HAST";
        String actual = solution.sortedHand(hand);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String hand = "H3SAHA";

        String expected = "H3HASA";
        String actual = solution.sortedHand(hand);

        Assert.assertEquals(expected, actual);
    }

}
