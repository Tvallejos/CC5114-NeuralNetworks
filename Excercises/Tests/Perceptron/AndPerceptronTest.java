package Perceptron;

import Perceptron.AbstractPerceptron;
import Perceptron.AndPerceptron;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AndPerceptronTest {


        private AbstractPerceptron and;

        @Before
        public void Setup(){
            and = new AndPerceptron();
        }

        @Test
        public void ZeroOne(){
            assertEquals(0,and.check(0,1));
        }

        @Test
        public void OneZero(){
            assertEquals(0,and.check(1,0));
        }

        @Test
        public void OneOne(){
            assertEquals(1,and.check(1,1));
        }

        @Test
        public void ZeroZero(){
            assertEquals(0,and.check(0,0));
        }


    }


