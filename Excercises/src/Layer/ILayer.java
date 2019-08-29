package Layer;

import java.util.ArrayList;

public interface ILayer {
    ArrayList<Double> feedNeurons(ArrayList<Double> X);

    ArrayList<Double> feedNextLayer(ArrayList<Double> X);

    ArrayList<Double> feed(ArrayList<Double> X);

    void setNextLayer(ILayer aLayer);

    void setPreviousLayer(ILayer aLayer);

    int getNumberOfNeurons();

    // TODO learn
    //double learn(ArrayList<Double> X,double desiredOutput);
}
