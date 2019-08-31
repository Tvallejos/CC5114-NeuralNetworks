package Layer;

import Perceptron.INeuron;

import java.util.ArrayList;

public class LastLayer extends AbstractLayer {

    public LastLayer(int numberOfNeurons, int numberOfinputs) {
        super(numberOfNeurons, numberOfinputs);
    }

    @Override
    public ArrayList<Double> feed(ArrayList<Double> inputs) {
        ArrayList<Double> Outputs = feedNeurons(inputs);
        return feedNeurons(Outputs);
    }

    @Override
    public void updateError(double desiredOutput) {
        for (INeuron neuron : neurons) {
            neuron.updateError(desiredOutput - neuron.getOutput());
        }

    }

    @Override
    public void updateWeightsAndBias(ArrayList<Double> inputs) {
        super.updateNeuronsWeightsAndBias(inputs);
    }
}
