package NeuralNetworks;

import java.util.ArrayList;

public interface INeuralNetwork {
    ArrayList<Double> feed(ArrayList<Double> X);

    void learn(ArrayList<Double> X, double desiredOutput);
}
