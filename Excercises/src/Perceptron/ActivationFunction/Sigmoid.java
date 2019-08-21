package Perceptron.ActivationFunction;

public class Sigmoid implements ActivationFunction {
    public Sigmoid(){
        super();
    }

    @Override
    public double apply(Double x) {

        double denominator = 1.0 + Math.exp(-x);
        return 1/denominator;
    }

    @Override
    public double derivative(Double x) {
        return apply(x)*(1.0-apply(x));
    }
}
