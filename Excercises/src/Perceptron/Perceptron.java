package Perceptron;

public interface Perceptron {
    int check(int x1,int x2);
    void learn(int x1,int x2, int desiredOutput);

}
