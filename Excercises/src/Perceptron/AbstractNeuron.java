package Perceptron;

import java.util.ArrayList;

public abstract class AbstractNeuron implements Perceptron {
    protected ArrayList<Double> W;
    protected double b;
    private double lr;
    protected int size;

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
    public void learn(ArrayList<Double> X, int desiredOutput) {
        double realOutput = check(X);
        double diff = desiredOutput - realOutput;
        int Xsize = X.size();
        assert (Xsize == size);
        for (int i = 0; i < size; i++) {
            W.set(i, W.get(i) + lr * X.get(i) * diff);
        }
        b += lr * diff;
    }

    public double weightedSum(ArrayList<Double> X) {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += X.get(i) * W.get(i);
        }
        return sum;
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
