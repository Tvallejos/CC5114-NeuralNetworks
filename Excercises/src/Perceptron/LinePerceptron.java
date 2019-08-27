package Perceptron;

import java.util.Random;

/**
 * Class which represents a perceptron that will be trained
 * to determine a line
 * <p>
 * initialized with random weights and bias values
 */
public class LinePerceptron extends BasePerceptron {
    public LinePerceptron(int seed) {
        super(2,2);
        Random r = new Random(seed);
        randomWeights(r);
    }

    public LinePerceptron() {
        this(new Random().nextInt());

    }

}
