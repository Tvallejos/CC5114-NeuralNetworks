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
    public void updateError(ArrayList<Double> desiredOutput) {
        int size = getNumberOfNeurons();
        for (int i = 0; i < size ; i++) {
            INeuron actualNeuron =neurons.get(i);
            actualNeuron.updateError(desiredOutput.get(i)-actualNeuron.getOutput());
        }
        previousLayer.updateError(desiredOutput);

    }

    @Override
    public void updateWeightsAndBias(ArrayList<Double> inputs) {
        super.updateNeuronsWeightsAndBias(inputs);
    }
}
