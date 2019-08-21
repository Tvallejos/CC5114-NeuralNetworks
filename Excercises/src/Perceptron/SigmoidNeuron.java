package Perceptron;

import Perceptron.ActivationFunction.Sigmoid;

import java.util.ArrayList;

public class SigmoidNeuron extends AbstractNeuron {


    public SigmoidNeuron(ArrayList<Double> W, int b) {
        super(W, b);
        this.f = new Sigmoid();
    }

    @Override
    public double feed(ArrayList<Double> X) {
        double x = weightedSum(X) + b;
        return f.apply(x);
    }

}
