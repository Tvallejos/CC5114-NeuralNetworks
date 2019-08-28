package Layer;

import java.util.ArrayList;

public class NullLayer extends AbstractLayer {
    public NullLayer() {
        super(0,null);
    }

    @Override
    public ArrayList<Double> feed(ArrayList<Double> inputs){
        return feedNeurons(inputs);
    }
}
