package Layer;

import Perceptron.*;

import java.util.ArrayList;

/**
 * @Author Tomas Vallejos
 * class which represents an abstract layer it implements the most of the Ilayer
 * interface methods
 */
public abstract class AbstractLayer implements ILayer {
    protected ArrayList<INeuron> neurons;
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

    protected ArrayList<Double> feedNeurons(ArrayList<Double> X) {
        ArrayList<Double> Outputs = new ArrayList<>();
        for (INeuron neuron : neurons) {
            Outputs.add(neuron.feed(X));
        }
        return Outputs;
    }

    private ArrayList<Double> feedNextLayer(ArrayList<Double> Outputs) {
        return nextLayer.feed(Outputs);
    }

    @Override
    public ArrayList<ArrayList<Double>> getListOfNeuronWeights() {
        ArrayList<ArrayList<Double>> listOfNeuronWeights = new ArrayList<>();
        for (INeuron neuron : neurons) {
            listOfNeuronWeights.add(neuron.getWeights());
        }
        return listOfNeuronWeights;
    }

    @Override
    public ArrayList<Double> getListOfNeuronDeltas() {
        ArrayList<Double> listOfNeuronDeltas = new ArrayList<>();
        for (int i = 0; i < neurons.get(0).getNumberOfInputs(); i++) {
            listOfNeuronDeltas.add(neurons.get(i).getDelta());
        }
        return listOfNeuronDeltas;
    }

    @Override
    public void updateError(double desiredOutput) {
        ArrayList<ArrayList<Double>> weights = nextLayer.getListOfNeuronWeights();
        ArrayList<Double> deltas = nextLayer.getListOfNeuronDeltas();
        int numOfNeurons = getNumberOfNeurons();
        for (int i = 0; i < numOfNeurons; i++) {
            Double newError = Sum(Multiply(weights.get(i), deltas.get(i)));
            neurons.get(i).updateError(newError);
        }
    }

    private Double Sum(ArrayList<Double> X) {
        Double sum = 0.0;
        int size = X.size();
        for (int i = 0; i < size; i++) {
            sum += X.get(i);
        }
        return sum;
    }

    private ArrayList<Double> Multiply(ArrayList<Double> X, double k) {
        ArrayList<Double> ans = new ArrayList<>();
        int size = X.size();
        for (int i = 0; i < size; i++) {
            ans.add(X.get(i) * k);
        }
        return ans;
    }


    private ArrayList<Double> getNeuronsOutputs() {
        ArrayList<Double> outputs = new ArrayList<>();
        for (INeuron neuron : neurons) {
            outputs.add(neuron.getOutput());
        }
        return outputs;
    }

    @Override
    public void updateWeightsAndBias(ArrayList<Double> inputs) {
        updateNeuronsWeightsAndBias(inputs);
        updateNextLayerWeightsAndBias();

    }

    protected void updateNeuronsWeightsAndBias(ArrayList<Double> inputs) {
        for (INeuron neuron : neurons) {
            neuron.updateWeightsAndBias(inputs);
        }
    }

    protected void updateNextLayerWeightsAndBias() {
        ArrayList<Double> outputs = getNeuronsOutputs();
        nextLayer.updateWeightsAndBias(outputs);
    }
}
