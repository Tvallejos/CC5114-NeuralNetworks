package NeuralNetworks;

import Layer.*;

import java.util.ArrayList;

public class NeuralNetwork implements INeuralNetwork {
    private ArrayList<ILayer> layers;

    //jp dijo k lo hiciera como fuera mas facil j3j3
    //ultimo parametro no se usa pk se puede deducir
    //de la cantidad de neuronas de la ultima layer
    public NeuralNetwork(int numberOfLayers, ArrayList<Integer> numberOfNeuronsPerLayer, int numberOfInputs, int numberOfOutputs) {
        layers = new ArrayList<>();
        addLayers(numberOfLayers, numberOfNeuronsPerLayer, numberOfInputs);
        connectLayers();
    }

    private void connectLayers() {
        int size = layers.size();
        for (int i = 1; i < size - 1; i++) {
            layers.get(i).setPreviousLayer(layers.get(i - 1));
            layers.get(i).setNextLayer(layers.get(i + 1));
        }
    }

    private void addLayers(int numberOfLayers, ArrayList<Integer> numberOfNeuronsPerLayer, int numberOfInputs) {
        assert (numberOfLayers == numberOfNeuronsPerLayer.size());
        assert (numberOfLayers > 1);// number of layers must be 2 or more

        addFirstLayer(numberOfNeuronsPerLayer.get(0), numberOfInputs);
        for (int i = 1; i < numberOfLayers - 1; i++) {
            addLayer(numberOfNeuronsPerLayer.get(i), numberOfNeuronsPerLayer.get(i - 1));
        }
        addLastLayer(numberOfNeuronsPerLayer.get(numberOfLayers - 1), numberOfNeuronsPerLayer.get(numberOfLayers - 1));

    }


    private void addLastLayer(int numberOfNeurons, int numberOfInputs) {
        layers.add(new LastLayer(numberOfNeurons, numberOfInputs));

    }

    private void addFirstLayer(int numberOfNeurons, int numberOfInputs) {
        layers.add(new FirstLayer(numberOfNeurons, numberOfInputs));

    }


    private void addLayer(int numberOfNeurons, int numberOfInputs) {
        layers.add(new HiddenLayer(numberOfNeurons, numberOfInputs));
    }

    @Override
    public ArrayList<Double> feed(ArrayList<Double> X) {
        return getFirstLayer().feed(X);
    }

    public ILayer getFirstLayer(){
        return layers.get(0);
    }

    @Override
    public void learn(ArrayList<Double> X, double desiredOutput) {
        getFirstLayer().feed(X);
        getLastLayer().updateError(desiredOutput);
    }

    private ILayer getLastLayer() {
        return layers.get(layers.size() - 1);
    }

}
