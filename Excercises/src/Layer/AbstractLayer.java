package Layer;

import Perceptron.*;

import java.util.ArrayList;

public abstract class AbstractLayer implements ILayer {
    private ArrayList<INeuron> neurons;
    private ILayer nextLayer;
    private ILayer previousLayer;

    public AbstractLayer(int numberOfNeurons,ILayer previousLayer){
        this.previousLayer = previousLayer;
        addNeurons(numberOfNeurons,previousLayer.getNumberOfNeurons());
    }

    private void addNeurons(int numberOfNeurons, int numberOfPreviousOutput){
        for (int i = 0; i<numberOfNeurons;i++){
            addNeuron(numberOfPreviousOutput);
        }
    }

    private void addNeuron(int numberOfPreviousOutput){
        neurons.add(new SigmoidNeuron(numberOfPreviousOutput));

    }

    public int getNumberOfNeurons(){
        return neurons.size();
    }

    public ArrayList<Double> feed(ArrayList<Double> inputs){
        ArrayList<Double> Outputs = feedNeurons(inputs);
        return feedNextLayer(Outputs);
    }

    public ArrayList<Double> feedNeurons(ArrayList<Double> X){
        ArrayList<Double> Outputs = new ArrayList<>();
        for (INeuron neuron: neurons) {
            Outputs.add(neuron.feed(X));
        }
        return Outputs;
    }

    public ArrayList<Double> feedNextLayer(ArrayList<Double> Outputs){
        return nextLayer.feed(Outputs);
    }


}
