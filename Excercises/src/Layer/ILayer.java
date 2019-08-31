package Layer;

import javafx.beans.binding.DoubleExpression;

import java.util.ArrayList;

public interface ILayer {
    ArrayList<Double> feedNeurons(ArrayList<Double> X);

    ArrayList<Double> feedNextLayer(ArrayList<Double> X);

    ArrayList<Double> feed(ArrayList<Double> X);

    void setNextLayer(ILayer aLayer);

    void setPreviousLayer(ILayer aLayer);

    int getNumberOfNeurons();

    void updateError(double desiredOutput);

    ArrayList<ArrayList<Double>> getListOfNeuronWeights();

    ArrayList<Double> getListOfNeuronDeltas();

    ArrayList<Double> getNeuronsOutputs();
    void updateWeightsAndBias(ArrayList<Double> inputs);
    // TODO learn
    //double learn(ArrayList<Double> X,double desiredOutput);
}
