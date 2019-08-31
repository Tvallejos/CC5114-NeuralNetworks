package Perceptron;

import Perceptron.ActivationFunction.ActivationFunction;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractNeuron implements INeuron {
    protected ArrayList<Double> W;
    protected double b;
    private double lr;
    protected int size;
    protected ActivationFunction f;
    protected double output;
    protected double error;
    protected double delta;

    public AbstractNeuron(int wNum, double b) {
        W = new ArrayList<>();
        size = wNum;
        this.b = b;
        this.lr = 0.1;
    }

    public AbstractNeuron(ArrayList<Double> W, double b) {
        this(W.size(), b);
        for (int i = 0; i < size; i++) {
            this.W.set(i, W.get(i));
        }
    }

    @Override
    public double feed(ArrayList<Double> X) {
        double x = weightedSum(X) + b;
        output = f.apply(x);
        return output;
    }

    @Override
    public void learn(ArrayList<Double> X, int desiredOutput) {
        assert (X.size() == size);
        double realOutput = feed(X);
        double diff = desiredOutput - realOutput;
        for (int i = 0; i < size; i++) {
            W.set(i, W.get(i) + lr * X.get(i) * diff);
        }
        b += lr * diff;
    }

    private double weightedSum(ArrayList<Double> X) {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += X.get(i) * W.get(i);
        }
        return sum;
    }

    protected void randomWeights(Random r) {
        for (int i = 0; i < size; i++) {
            Double randomNumber = r.nextDouble();
            W.add(i, randomNumber);
        }
        this.b = r.nextDouble();
    }

    @Override
    public void updateError(double anError) {
        error = anError;
        updateDelta();
    }

    protected void updateDelta() {
        delta = error * (output - (1.0 - output));
    }

    @Override
    public double getOutput() {
        return output;
    }

    @Override
    public ArrayList<Double> getWeights() {
        return W;
    }

    @Override
    public double getDelta() {
        return delta;
    }

    @Override
    public int getNumberOfInputs() {
        return W.size();
    }

    @Override
    public void updateWeightsAndBias(ArrayList<Double> input) {
        for (int i = 0; i < size; i++) {
            W.set(i, W.get(i) + (lr * delta * input.get(i)));
        }
        b += (lr * delta);
    }
    /*public ArrayList<Double> normalize(ArrayList<Integer> X, int dl, int dh, Double nh, Double nl) {
        int Xsize = X.size();
        ArrayList<Double> normalizedInput = new ArrayList<>();
        for (int i = 0; i < Xsize; i++) {
            int actualX = X.get(i);
            Double normalizedValue =
                    ((actualX - dl) * (nh - nl) /
                            (dh - dl)) + nl;
            normalizedInput.add(normalizedValue);
        }
        return normalizedInput;
    }

    public ArrayList<Integer> deNormalize(ArrayList<Double> X, int dl, int dh, Double nh, Double nl) {

    }
    */
}
