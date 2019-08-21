package Perceptron.ActivationFunction;

public class Tanh implements ActivationFunction {
    public Tanh(){
        super();
    }

    @Override
    public double apply(Double x) {
        double numerator = Math.exp(x) - Math.exp(-x);
        double denominator = Math.exp(x) + Math.exp(-x);
        return numerator/denominator;
    }

    @Override
    public double derivative(Double x) {
        return 1-apply(x)*apply(x);
    }
}
