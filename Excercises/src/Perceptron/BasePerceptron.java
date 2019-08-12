package Perceptron;

/**
 * Abstract implementation from
 */
public class BasePerceptron extends AbstractNeuron {



    BasePerceptron(int w1, int w2, int b) {
        super(w1,w2,b);

    }

    @Override
    public double check(double x1, double x2) {
        // if weighted sum + b <= 0 -> false
        if (x1 * w1 + x2 * w2 + b <= 0) {
            return 0;
        } else {
            return 1;
        }

    }

    public double getW1() {
        return w1;
    }

    public double getW2() {
        return w2;
    }

    public double getB() {
        return b;
    }

}
