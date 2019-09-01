package Perceptron;

import java.util.ArrayList;

/**
 * @Author Tomas Vallejos
 * Interface to represent a Neuron
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

    /**
     * it sets the neuron error to anError
     *
     * @param anError
     */
    void updateError(double anError);

    /**
     * gets the neuron output
     * @return
     */
    double getOutput();

    /**
     * Gets the neuron list of weights
     * @return
     */
    ArrayList<Double> getWeights();

    /**
     * Gets the neuron delta
     * @return
     */
    double getDelta();

    /**
     * Gets the number of inputs which the neuron recives
     * @return
     */
    int getNumberOfInputs();

    /**
     * updates the weights and bias of the neuron with a formula
     * which includes an input
     *
     * @param input
     */
    void updateWeightsAndBias(ArrayList<Double> input);
}
