package Perceptron;

/**
 * Abstract implementation from
 */
public class BasePerceptron implements Perceptron {
    protected double w1;
    protected double w2;
    protected double b;
    private double lr;


    BasePerceptron(int w1, int w2, int b) {
        this.w1 = w1;
        this.w2 = w2;
        this.b = b;
        this.lr = 0.1;

    }

    @Override
    public int check(double x1, double x2) {
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

    public void learn(double x1, double x2, int desiredOutput) {
        int realOutput = check(x1, x2);
        int diff = desiredOutput - realOutput;

        this.w1 += lr * x1 * diff;
        this.w2 += lr * x2 * diff;

        b += lr * diff;
    }
}
