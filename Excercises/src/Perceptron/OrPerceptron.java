package Perceptron;

/**
 * Class which represents an or gate
 */
public class OrPerceptron extends BasePerceptron {
    public OrPerceptron() {
        super(2, -1);
        W.add(0,2.0);
        W.add(1,2.0);
    }
}
