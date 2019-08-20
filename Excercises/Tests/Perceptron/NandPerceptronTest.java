package Perceptron;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class NandPerceptronTest {

    private static double delta = 0.0000001;
    private BasePerceptron nand;

    public ArrayList<Double> arrayListWith(Double x1, Double x2) {
        ArrayList<Double> input1 = new ArrayList<>();
        input1.add(x1);
        input1.add(x2);
        return input1;
    }

    @Before
    public void Setup() {
        nand = new NandPerceptron();
    }

    @Test
    public void ZeroOne() {
        assertEquals(1, nand.check(arrayListWith(0.0, 1.0)), delta);
    }

    @Test
    public void OneZero() {
        assertEquals(1, nand.check(arrayListWith(1.0, 0.0)), delta);
    }

    @Test
    public void OneOne() {
        assertEquals(0, nand.check(arrayListWith(1.0, 1.0)), delta);
    }

    @Test
    public void ZeroZero() {
        assertEquals(1, nand.check(arrayListWith(0.0, 0.0)), delta);
    }


}
