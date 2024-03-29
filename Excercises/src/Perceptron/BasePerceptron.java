package Perceptron;

import Perceptron.ActivationFunction.Sigmoid;
import Perceptron.ActivationFunction.Step;

import java.util.ArrayList;

/**
 * Abstract implementation from
 */
public class BasePerceptron extends AbstractNeuron {



    BasePerceptron(ArrayList<Double> W, double b) {
        super(W,b);
        this.f = new Step();
    }

    BasePerceptron(int w,double b){
        super(w,b);
        this.f = new Step();
    }

    public ArrayList<Double> getW(){
        return W;
    }
    public double getB() {
        return b;
    }

}
