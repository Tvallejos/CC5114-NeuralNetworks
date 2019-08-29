package Layer;

import Perceptron.*;

import java.util.ArrayList;

public abstract class AbstractLayer implements ILayer {
    private ArrayList<INeuron> neurons;
    protected ILayer nextLayer;
    protected ILayer previousLayer;

    public AbstractLayer(int numberOfNeurons, int numberOfInputs) {
        neurons = new ArrayList<>();
        addNeurons(numberOfNeurons, numberOfInputs);
    }

    private void addNeurons(int numberOfNeurons, int numberOfInputs) {
        for (int i = 0; i < numberOfNeurons; i++) {
            addNeuron(numberOfInputs);
        }
    }

    private void addNeuron(int numberOfInputs) {
        neurons.add(new SigmoidNeuron(numberOfInputs));
    }

    public int getNumberOfNeurons() {
        return neurons.size();
    }

    public void setNextLayer(ILayer aLayer) {
        this.nextLayer = aLayer;
    }

    public void setPreviousLayer(ILayer aLayer) {
        this.previousLayer = aLayer;
    }

    public ArrayList<Double> feed(ArrayList<Double> inputs) {
        ArrayList<Double> Outputs = feedNeurons(inputs);
        return feedNextLayer(Outputs);
    }

    public ArrayList<Double> feedNeurons(ArrayList<Double> X) {
        ArrayList<Double> Outputs = new ArrayList<>();
        for (INeuron neuron : neurons) {
            Outputs.add(neuron.feed(X));
        }
        return Outputs;
    }

    public ArrayList<Double> feedNextLayer(ArrayList<Double> Outputs) {
        return nextLayer.feed(Outputs);
    }


}
