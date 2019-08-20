package Perceptron;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

public class OrPerceptronTest {
    private BasePerceptron or;
    private static double delta = 0.0000001;

    public ArrayList<Double> arrayListWith(Double x1, Double x2) {
        ArrayList<Double> input1 = new ArrayList<>();
        input1.add(x1);
        input1.add(x2);
        return input1;
    }
    
    @Before
    public void Setup(){
        or = new OrPerceptron();
    }

    @Test
    public void ZeroOne(){

        assertEquals(1,or.check(arrayListWith(0.0,1.0)),delta);
    }

    @Test
    public void OneZero(){
        assertEquals(1,or.check(arrayListWith(1.0,0.0)),delta);
    }

    @Test
    public void OneOne(){
        assertEquals(1,or.check(arrayListWith(1.0,1.0)),delta);
    }

    @Test
    public void ZeroZero(){
        assertEquals(0,or.check(arrayListWith(0.0,0.0)),delta);
    }


}
