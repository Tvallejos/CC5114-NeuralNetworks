package NeuralNetworks;

import java.util.ArrayList;

/**
 * Author Tomas Vallejos
 * Interface for a Neural Network
 */
public interface INeuralNetwork {
    /**
     * feeds the first layer with the input and layers keeps forward feeding
     * until the last one
     *
     * @param X input
     * @return last layer neuron outputs
     */
    ArrayList<Double> feed(ArrayList<Double> X);

    /**
     * feeds the layers, they forward feed
     * then backpropagate the error
     * then update of all weights and bias in all layers
     *
     * @param X             input
     * @param desiredOutput
     */
    void learn(ArrayList<Double> X, ArrayList<Double> desiredOutput);

    double getLoss();

    void train(int percentageOfTraining);

    void train(int percentageOfTraining, int epoch);

    void setData(String filePath);
}
