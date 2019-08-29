package Layer;

public class HiddenLayer extends AbstractLayer {
    public HiddenLayer(int numberOfNeurons, int numberOfInputs) {
        super(numberOfNeurons, numberOfInputs);
    }

    @Override
    public void updateError(double desiredOutput) {
        super.updateError(desiredOutput);
        previousLayer.updateError(desiredOutput);
    }
}
