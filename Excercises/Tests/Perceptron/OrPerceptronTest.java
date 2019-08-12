package Perceptron;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class OrPerceptronTest {
    private BasePerceptron or;
    private static double delta = 0.0000001;

    @Before
    public void Setup(){
        or = new OrPerceptron();
    }

    @Test
    public void ZeroOne(){

        assertEquals(1,or.check(0,1),delta);
    }

    @Test
    public void OneZero(){
        assertEquals(1,or.check(1,0),delta);
    }

    @Test
    public void OneOne(){
        assertEquals(1,or.check(1,1),delta);
    }

    @Test
    public void ZeroZero(){
        assertEquals(0,or.check(0,0),delta);
    }


}
