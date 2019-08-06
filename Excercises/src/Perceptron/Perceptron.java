package Perceptron;

public interface Perceptron {
    int check(double x1, double x2);

    void learn(double x1, double x2, int desiredOutput);

}
