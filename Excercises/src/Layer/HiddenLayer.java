package Layer;

import java.util.ArrayList;

public class HiddenLayer extends AbstractLayer {
    public HiddenLayer(int numberOfNeurons, int numberOfInputs) {
        super(numberOfNeurons, numberOfInputs);
    }

    @Override
    public void updateError(ArrayList<Double> desiredOutput) {
        super.updateError(desiredOutput);
        previousLayer.updateError(desiredOutput);
    }
}
