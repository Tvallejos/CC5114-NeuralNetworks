package Layer;

public class FirstLayer extends AbstractLayer {

    public FirstLayer(int numberOfNeurons, int numberOfInputs) {
        super(numberOfNeurons, numberOfInputs);
        setPreviousLayer(new NullLayer());
    }

    @Override
    public void setPreviousLayer(ILayer aLayer) {
        this.previousLayer = new NullLayer();
    }

}
