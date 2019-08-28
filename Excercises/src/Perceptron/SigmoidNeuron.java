package Perceptron;

import Perceptron.ActivationFunction.Sigmoid;

import java.util.ArrayList;
import java.util.Random;

public class SigmoidNeuron extends AbstractNeuron {

    public SigmoidNeuron(int Wnum){
        this(Wnum, new Random().nextDouble());
    }

    public SigmoidNeuron(int Wnum, double b){
        super(Wnum,b);
        this.f= new Sigmoid();
        randomWeights(new Random());
    }

    public SigmoidNeuron(ArrayList<Double> W, int b) {
        super(W, b);
        this.f = new Sigmoid();
    }

    @Override
    public double feed(ArrayList<Double> X) {
        double x = weightedSum(X) + b;
        if(f.apply(x)<0.5){
            return 0;
        }else
            return 1;
    }

}
