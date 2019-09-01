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

    /**
     * Returns the MSE of the last evaluate part in a train
     * @return  MSE
     */
    double getLoss();

    /**
     * It trains the NN with the set dataset and percentage of training
     * and then evaluates the NN performance with the rest of the dataset
     * @param percentageOfTraining
     */
    void train(int percentageOfTraining);

    /**
     * trains for a number of epoch
     * @param percentageOfTraining
     * @param epoch
     */
    void train(int percentageOfTraining, int epoch);

    /**
     * set the Dataset from a filePath
     * @param filePath
     */
    void setData(String filePath);

    /**
     * returns the confusion matrix of the last training
     * @return confusion Matrix
     */
    ArrayList<ArrayList<Integer>> getConfusionMatrix();

    /**
     * returns the accuracy percentage
     * @return
     */
    double getAccuracy();
}
