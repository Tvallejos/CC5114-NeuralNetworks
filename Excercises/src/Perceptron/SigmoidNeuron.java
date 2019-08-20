package Perceptron;

import java.util.ArrayList;

public class SigmoidNeuron extends AbstractNeuron {


    public SigmoidNeuron(ArrayList<Double> W, int b) {
        super(W, b);
    }

    @Override
    public double check(ArrayList<Double> X) {
        double z = Math.exp(-(weightedSum(X) + b));
        return z;
    }

}
