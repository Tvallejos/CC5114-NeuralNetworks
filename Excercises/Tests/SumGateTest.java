import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumGateTest {

    private SumGate sumGate;
    private static double delta = 0.0000001;

    @Before
    public void Setup() {
        sumGate = new SumGate();
    }

    @Test
    public void ZeroOne() {
        sumGate.sum(0,1);

        assertEquals(1,sumGate.getSum(),delta );
        assertEquals(0,sumGate.getCarry(),delta);
    }

    @Test
    public void OneZero() {
        sumGate.sum(1,0);

        assertEquals(1,sumGate.getSum() ,delta);
        assertEquals(0,sumGate.getCarry(),delta);
    }

    @Test
    public void OneOne() {
        sumGate.sum(1,1);

        assertEquals(0,sumGate.getSum() ,delta);
        assertEquals(1,sumGate.getCarry(),delta);
    }

    @Test
    public void ZeroZero() {
        sumGate.sum(0,0);

        assertEquals(0,sumGate.getSum(),delta );
        assertEquals(0,sumGate.getCarry(),delta);
    }

    @Test(expected = AssertionError.class)
    public void TwoTwo(){
        sumGate.sum(2,2);
        //boolean pass = false;
        //try {sumGate.sum(2,2);} catch (AssertionError e){
        //    pass = true;
        //}
        //assertTrue(pass);
    }
}




