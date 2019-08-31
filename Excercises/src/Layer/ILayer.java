package Layer;

import java.util.ArrayList;

/**
 * @Author Tomas Vallejos
 * Interface for Neural Networks implementation
 */
public interface ILayer {
    /**
     * Feeds every neuron with the input
     * @param X input
     * @return ArrayList which has at index i the output of the i-th neuron
     */
    //ArrayList<Double> feedNeurons(ArrayList<Double> X);

    /**
     * feed the next layer with some input
     * @param X input
     * @return
     */
    //ArrayList<Double> feedNextLayer(ArrayList<Double> X);

    /**
     * Feeds every neuron with the input and feeds the next layer with the output
     *
     * @param X input
     * @return the last layer output
     */
    ArrayList<Double> feed(ArrayList<Double> X);

    /**
     * replaces the nextLayer with aLayer
     *
     * @param aLayer
     */
    void setNextLayer(ILayer aLayer);

    /**
     * replaces the previousLayer with aLayer
     *
     * @param aLayer
     */
    void setPreviousLayer(ILayer aLayer);

    /**
     * get the number of neurons of the layer
     *
     * @return number of neurons
     */
    int getNumberOfNeurons();

    /**
     * update the error of each neuron and backpropagates it
     *
     * @param desiredOutput
     */
    void updateError(double desiredOutput);

    /**
     * get the list of each neuron set of weights
     *
     * @return the list of each neuron set of weights
     */
    ArrayList<ArrayList<Double>> getListOfNeuronWeights();

    /**
     * get the list of each neuron set of deltas
     *
     * @return the list of each neuron set of deltas
     */
    ArrayList<Double> getListOfNeuronDeltas();

    //ArrayList<Double> getNeuronsOutputs();

    /**
     * updates the weights and bias of every neuron and forward propagates it
     * until the last layer
     *
     * @param inputs layer inputs, these are part of the weight update formula
     */
    void updateWeightsAndBias(ArrayList<Double> inputs);
    // TODO learn
    //double learn(ArrayList<Double> X,double desiredOutput);
}
