package Perceptron;

import java.util.ArrayList;

/**
 * Class which represents an and gate
 */
public class AndPerceptron extends BasePerceptron {
    public AndPerceptron() {
        super(2, -3);
        W.add(0, 2.0);
        W.add(1, 2.0);
    }
}
