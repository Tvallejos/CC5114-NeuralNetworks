package Perceptron;

import java.util.Random;

/**
 * Class which represents a perceptron that will be trained
 * to determine a line
 *
 * initialized with random weights and bias values
 */
public class LinePerceptron extends BasePerceptron {
    public LinePerceptron(int seed) {
        super(0, 0, 0);
        int low = -2;
        int high = 2;
        Random r = new Random(seed);
        randomWeights(r, high, low);
    }

    public LinePerceptron() {
        this(new Random().nextInt());

    }


    private void randomWeights(Random r, int high, int low) {
        this.w1 = r.nextInt(high - low) + low;
        this.w2 = r.nextInt(high - low) + low;
        this.b = r.nextInt(high - low) + low;
    }
}
