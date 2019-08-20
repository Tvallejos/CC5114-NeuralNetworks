package Perceptron;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AndPerceptronTest {


        private BasePerceptron and;
        private static double delta = 0.0000001;

    public ArrayList<Double> arrayListWith(Double x1, Double x2) {
        ArrayList<Double> input1 = new ArrayList<>();
        input1.add(x1);
        input1.add(x2);
        return input1;
    }
        
        @Before
        public void Setup(){
            and = new AndPerceptron();
        }

        @Test
        public void ZeroOne(){
            assertEquals(0,and.check(arrayListWith(0.0,1.0)),delta);
        }

        @Test
        public void OneZero(){
            assertEquals(0,and.check(arrayListWith(1.0,0.0)),delta);
        }

        @Test
        public void OneOne(){
            assertEquals(1,and.check(arrayListWith(1.0,1.0)),delta);
        }

        @Test
        public void ZeroZero(){
            assertEquals(0,and.check(arrayListWith(0.0,0.0)),delta);
        }


    }


