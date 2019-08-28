package NeuralNetworks;

import java.util.ArrayList;

public interface INeuralNetwork {
    void addLayers(int numberOfLayers,ArrayList<Integer> numberOfNeuronsPerLayer);
    void addLayer(int numberOfNeurons);
    double feed(ArrayList<Double> X);
    double learn(ArrayList<Double> X,double desiredOutput);
}
