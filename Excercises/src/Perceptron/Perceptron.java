package Perceptron;

/**
 * Class to represent a perceptron
 */
public interface Perceptron {
    /**
     * This method checks the output of the perceptron by the given input
     * @param x1 input 1
     * @param x2 input 2
     * @return Rosenblatt computed output
     */
    int check(double x1, double x2);

    /**
     * Supervised learning algorithm, if the real output is different from the
     * desired one then the perceptron must learn (update some weights and bias)
     * @param x1 input 1
     * @param x2 input 2
     * @param desiredOutput the example output to learn
     */
    void learn(double x1, double x2, int desiredOutput);

}
