package Layer;

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
}
