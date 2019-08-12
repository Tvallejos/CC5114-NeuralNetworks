package Perceptron;

public class SigmoidNeuron extends AbstractNeuron {


    public SigmoidNeuron(int w1, int w2, int b) {
        super(w1, w2, b);
    }

    @Override
    public double check(double x1, double x2) {
        double weightedSum = x1 * w1 + x2 * w2;
        double z = Math.exp(-(weightedSum + b));
        return z;
    }

    @Override
    public void learn(double x1, double x2, int desiredOutput) {
        super.learn(x1,x2,desiredOutput);
    }
}
