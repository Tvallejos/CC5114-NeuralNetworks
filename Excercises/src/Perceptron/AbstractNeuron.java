package Perceptron;

public abstract class AbstractNeuron implements Perceptron{
    protected double w1;
    protected double w2;
    protected double b;
    private double lr;

    public AbstractNeuron(int w1,int w2,int b){

        this.w1 = w1;
        this.w2 = w2;
        this.b = b;
        this.lr = 0.1;
    }

    @Override
    public void learn(double x1, double x2, int desiredOutput) {
        double realOutput = check(x1, x2);
        double diff = desiredOutput - realOutput;

        this.w1 += lr * x1 * diff;
        this.w2 += lr * x2 * diff;

        b += lr * diff;
    }
}
