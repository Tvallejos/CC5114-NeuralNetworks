package Layer;

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
    // TODO learn
    //double learn(ArrayList<Double> X,double desiredOutput);
}
