package Perceptron;

import Perceptron.ActivationFunction.Sigmoid;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author Tomas Vallejos
 * Class which represents a neuron with sigmoid activation function
 */
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

}
