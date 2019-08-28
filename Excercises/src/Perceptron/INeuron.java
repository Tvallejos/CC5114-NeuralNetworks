package Perceptron;

import java.util.ArrayList;

/**
 * Class to represent a perceptron
 */
public interface INeuron {
    /**
     * This method checks the output of the perceptron by the given input
     *
     * @param X Array of inputs
     * @return Rosenblatt computed output
     */
    double feed(ArrayList<Double> X);

    /**
     * Supervised learning algorithm, if the real output is different from the
     * desired one then the perceptron must learn (update some weights and bias)
     *
     * @param X             Array of inputs
     * @param desiredOutput the example output to learn
     */
    void learn(ArrayList<Double> X, int desiredOutput);

    double weightedSum(ArrayList<Double> X);

    // normalizacion va a nivel de red
    //ArrayList<Double> normalize(ArrayList<Integer> X, int dl, int dh, Double nh, Double nl);
    //ArrayList<Integer> deNormalize(ArrayList<Double> X, int dl, int dh, Double nh, Double nl);
}
