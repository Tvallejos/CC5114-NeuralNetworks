package Perceptron;

import java.util.ArrayList;

/**
 * Abstract implementation from
 */
public class BasePerceptron extends AbstractNeuron {



    BasePerceptron(ArrayList<Double> W, double b) {
        super(W,b);
    }

    BasePerceptron(int w,double b){
        super(w,b);
    }

    @Override
    public double check(ArrayList<Double> X) {
        // if weighted sum + b <= 0 -> false
        if (weightedSum(X) + b <= 0) {
            return 0;
        } else {
            return 1;
        }

    }
    public ArrayList<Double> getW(){
        return W;
    }
    public double getB() {
        return b;
    }

}
