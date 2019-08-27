package Perceptron.ActivationFunction;


/**
 * @author Tomas Vallejos
 * Class implementation to calculate the step function
 */
public class Step implements ActivationFunction{
    public Step(){
        super();
    }

    @Override
    public double apply(Double x) {
        if(x<0){ return 0;
        }else{ return 1;}
    }

    @Override
    public double derivative(Double x) {
        return 0;
    }
}
