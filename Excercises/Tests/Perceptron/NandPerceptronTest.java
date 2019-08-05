package Perceptron;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NandPerceptronTest {


    private AbstractPerceptron nand;

    @Before
    public void Setup() {
        nand = new NandPerceptron();
    }

    @Test
    public void ZeroOne() {
        assertEquals(1, nand.check(0, 1));
    }

    @Test
    public void OneZero() {
        assertEquals(1, nand.check(1, 0));
    }

    @Test
    public void OneOne() {
        assertEquals(0, nand.check(1, 1));
    }

    @Test
    public void ZeroZero() {
        assertEquals(1, nand.check(0, 0));
    }


}
