package Perceptron;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AndPerceptronTest {


        private BasePerceptron and;
        private static double delta = 0.0000001;

        @Before
        public void Setup(){
            and = new AndPerceptron();
        }

        @Test
        public void ZeroOne(){
            assertEquals(0,and.check(0,1),delta);
        }

        @Test
        public void OneZero(){
            assertEquals(0,and.check(1,0),delta);
        }

        @Test
        public void OneOne(){
            assertEquals(1,and.check(1,1),delta);
        }

        @Test
        public void ZeroZero(){
            assertEquals(0,and.check(0,0),delta);
        }


    }


