package Perceptron.ActivationFunction;

/**
 * @author tomas vallejos
 * Public Interface for neuron's activation functions
 */
public interface ActivationFunction {

    /**
     * Apply the activation function to the input x
     * @param x input
     * @return the result of the function applied to x
     */
    double apply(Double x);

    /**
     * Apply the derivative of activation function to the input x
     * @param x input
     * @return the result of the derivative of the function applied to x
     */
    double derivative(Double x);

}
