package NeuralNetworks;

import Layer.*;

import java.util.ArrayList;

public class NeuralNetwork implements INeuralNetwork {
    private ArrayList<ILayer> layers;

    public NeuralNetwork(int numberOfLayers, ArrayList<Integer> numberOfNeuronsPerLayer){
        addLayers(numberOfLayers,numberOfNeuronsPerLayer);
    }


    @Override
    public void addLayers(int numberOfLayers, ArrayList<Integer> numberOfNeuronsPerLayer) {
        assert(numberOfLayers == numberOfNeuronsPerLayer.size());
        addFirstLayer(numberOfLayers,numberOfNeuronsPerLayer);
        for(int i = 1; i<numberOfLayers-1;i++){
            addLayer(numberOfNeuronsPerLayer.get(i));
        }
        addLastLayer(numberOfNeuronsPerLayer.get(numberOfLayers-1));
    }

    private void addLastLayer(int numberOfNeurons) {
        layers.add(new LastLayer(numberOfNeurons,getLastLayer()));

    }

    private void addFirstLayer(int numberOfLayers, ArrayList<Integer> numberOfNeuronsPerLayer) {
        if(numberOfLayers>0){
            layers.add(new FirstLayer(numberOfNeuronsPerLayer.get(0)));
        }
    }

    @Override
    public void addLayer(int numberOfNeurons) {
        ILayer previousLayer = getLastLayer();
        layers.add(new HiddenLayer(numberOfNeurons,previousLayer));
    }

    private ILayer getLastLayer() {
        return layers.get(layers.size()-1);
    }

    @Override
    public double feed(ArrayList<Double> X) {
        return 0;
    }

    @Override
    public double learn(ArrayList<Double> X, double desiredOutput) {
        return 0;
    }
}
