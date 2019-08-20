package Perceptron;

/**
 * Class which represents a nand gate
 */
public class NandPerceptron extends BasePerceptron {
    public NandPerceptron() {
        super(2, 3);
        W.add(0, -2.0);
        W.add(1, -2.0);
    }
}
